package com.ncproject.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.time.Instant;
import com.ncproject.backend.repositories.UserSummaryRepository;
import com.ncproject.backend.model.UserSummary;

@Service
@AllArgsConstructor
public class UserSummaryService {
    private final UserSummaryRepository userSummaryRepository;

    public UserSummary getUserSummaryById(UUID id) {
        return userSummaryRepository.getOne(id);
    }

    public UserSummary getUserSummaryByEmail(String email) {
        return userSummaryRepository.getByEmail(email);
    }

    public UserSummary getUserSummaryByAccessToken(String accessToken) {
        return  userSummaryRepository.getByAccessToken(accessToken);
    }

    void addUser(UserSummary userSummary) {
        if (userSummaryRepository.existsByEmail(userSummary.getEmail())) {
            if (userSummaryRepository.getByEmail(userSummary.getEmail())
                                                .getExpiresAt().isBefore(Instant.now())) {
                userSummaryRepository.delete(userSummary);
                userSummaryRepository.save(userSummary);
            }
        }
        else {
            userSummaryRepository.save(userSummary);
        }
    }
}
