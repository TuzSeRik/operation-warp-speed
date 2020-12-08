package com.ncproject.backend.services;

import com.ncproject.backend.model.PendingInvitation;
import com.ncproject.backend.repositories.PendingInvitationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PendingInvitationService {
    PendingInvitationRepository pendingInvitationRepository;
    public void saveInvitation(PendingInvitation pendingInvitation) {
        pendingInvitationRepository.saveAndFlush(pendingInvitation);
    }
}
