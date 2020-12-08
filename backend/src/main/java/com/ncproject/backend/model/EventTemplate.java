package com.ncproject.backend.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Entity
@Table(name = "EVENT_TEMPLATES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventTemplate {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID userId;
    private String summary;
    @Lob
    private String description;
    @JsonIgnore
    private DateTime startTime;
    private String startTimeString;
    @ElementCollection
    private List<String> attendees;
    private String location;

    public void setStartTime(EventDateTime startTime) {
        if (startTime != null && startTime.getDateTime() != null) {
            this.startTime = startTime.getDateTime();
            startTimeString = this.startTime.toStringRfc3339();
        }
        else {
            this.startTime = new DateTime(0);
            startTimeString = "";
        }
    }

    public void setAttendees(List<EventAttendee> attendees) {
        this.attendees = (attendees == null) ?
                new ArrayList<>() :
                attendees.stream().map(EventAttendee::getEmail).collect(Collectors.toList());
    }
}
