package com.ncproject.backend.services;

import java.util.List;
import java.util.UUID;
import com.ncproject.backend.repositories.EventTemplateRepository;
import com.ncproject.backend.model.EventTemplate;

public class EventTemplateService {
    EventTemplateRepository eventTemplateRepository;

    public void saveBulkOfEvents(List<EventTemplate> events) {
        for (EventTemplate event : events) {
            eventTemplateRepository.save(event);
        }
        eventTemplateRepository.flush();
    }

    public void saveOneEventTemplate(EventTemplate eventTemplate) {
        eventTemplateRepository.saveAndFlush(eventTemplate);
    }

    public List<EventTemplate> getAllEventTemplatesForUser(UUID id) {
        return eventTemplateRepository.findAllByUserId(id);
    }
}
