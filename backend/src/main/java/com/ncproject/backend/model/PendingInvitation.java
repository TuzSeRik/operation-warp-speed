package com.ncproject.backend.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PENDING_INVITATIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingInvitation {
    @Id
    @GeneratedValue
    UUID id;
    String to;
    String from;
    String subject;
    @Lob
    String bodyText;
}
