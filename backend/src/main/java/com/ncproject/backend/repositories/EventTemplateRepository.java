package com.ncproject.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;
import com.ncproject.backend.model.EventTemplate;

public interface EventTemplateRepository extends JpaRepository<EventTemplate, UUID> {
    List<EventTemplate> findAllByUserId(UUID userId);
}
