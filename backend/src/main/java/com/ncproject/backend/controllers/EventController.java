package com.ncproject.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.services.calendar.Calendar;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.model.Events;
import com.google.api.services.calendar.model.Event;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.Instant;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.ncproject.backend.services.EventTemplateService;
import com.ncproject.backend.services.UserSummaryService;
import com.ncproject.backend.model.EventTemplate;
import com.ncproject.backend.model.UserSummary;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@AllArgsConstructor
public class EventController {
    private final EventTemplateService eventTemplateService;
    private final UserSummaryService userSummaryService;

    @GetMapping("/api/events")
    List<EventTemplate> getEvents(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client) throws IOException {
        UserSummary userSummary = userSummaryService
                                    .getUserSummaryByAccessToken(client.getAccessToken().getTokenValue());
        Credential credential = new Credential(BearerToken.authorizationHeaderAccessMethod())
                                    .setAccessToken(userSummary.getAccessToken());

        Calendar calendar = new Calendar.Builder(
                new NetHttpTransport(),
                    JacksonFactory.getDefaultInstance(),
                    credential)
                .setApplicationName("JustMeet")
                .build();

        Events events = calendar.events().list("primary")
                .setTimeMin(new DateTime(LocalDateTime
                                .ofInstant(userSummary.getLastSynchronisation(),
                                            ZoneOffset.ofHours(3)).toString()))
                .setTimeMax(new DateTime(LocalDateTime.now().plusYears(1).toString()))
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();

        List<Event> proceedingEvents = events.getItems();
        ArrayList<EventTemplate> proceededEvents = new ArrayList<>();
        for (Event event : proceedingEvents) {
            EventTemplate proceededEvent = new EventTemplate();
            proceededEvent.setId(new UUID(0, 0));
            proceededEvent.setUserId(userSummary.getId());
            proceededEvent.setSummary(event.getSummary());
            proceededEvent.setDescription(event.getDescription());
            proceededEvent.setStartTime(event.getOriginalStartTime());
            proceededEvent.setAttendees(event.getAttendees());
            proceededEvent.setLocation(event.getLocation());

            proceededEvents.add(proceededEvent);
        }

        eventTemplateService.saveBulkOfEvents(proceededEvents);

        userSummary.setLastSynchronisation(Instant.now());
        userSummaryService.saveUser(userSummary);

        return eventTemplateService
                .getAllEventTemplatesForUser(userSummary.getId());
    }

    @PostMapping("/api/event")
    EventTemplate addEvent(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
                           @RequestBody EventTemplate eventTemplate) throws IOException {
        eventTemplateService.saveOneEventTemplate(eventTemplate);

        Credential credential = new Credential(BearerToken.authorizationHeaderAccessMethod())
                .setAccessToken(client.getAccessToken().getTokenValue());

        Calendar calendar = new Calendar.Builder(
                new NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                credential)
                .setApplicationName("JustMeet")
                .build();

        calendar.events().insert("primary",
                new Event()
                            .setDescription(eventTemplate.getDescription())
                            .setStart(new EventDateTime().setDateTime(eventTemplate.getStartTime()))
                            .setAttendees(eventTemplate.getAttendees()
                                    .stream().map(s -> new EventAttendee().setEmail(s))
                                             .collect(Collectors.toList()))
                            .setLocation(eventTemplate.getLocation()));

        return eventTemplate;
    }
}
