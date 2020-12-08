package com.ncproject.backend.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;
import java.time.Instant;

@Entity
@Table(name = "USER_SUMMARIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSummary {
    @Id
    private UUID id;
    @Column(unique = true)
    private String email;
    private String givenName;
    private String lastName;
    private String profilePicture;
    private String accessToken;
    private Instant lastSynchronisation;
}
