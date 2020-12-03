package com.ncproject.backend.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.google.api.client.util.DateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "EVENT_TEMPLATES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventTemplate {
    @Id
    @GeneratedValue
    UUID id;
    UUID userId;
    String description;
    @JsonIgnore
    DateTime startTime;
    String startTimeString;
    @ElementCollection
    List<String> attendees;
    String location;
}
