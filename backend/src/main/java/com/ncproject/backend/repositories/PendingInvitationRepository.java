package com.ncproject.backend.repositories;

import com.ncproject.backend.model.PendingInvitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PendingInvitationRepository extends JpaRepository<PendingInvitation, UUID> {
}
