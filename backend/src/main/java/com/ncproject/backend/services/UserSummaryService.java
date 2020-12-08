package com.ncproject.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;
import com.ncproject.backend.repositories.UserSummaryRepository;
import com.ncproject.backend.model.UserSummary;

@Service
@AllArgsConstructor
public class UserSummaryService {
    private final UserSummaryRepository userSummaryRepository;

    public boolean userSummaryExistsByEmail(String email) {
        return userSummaryRepository.existsByEmail(email);
    }

    public UserSummary getUserSummaryById(UUID id) {
        return userSummaryRepository.getOne(id);
    }

    public UserSummary getUserSummaryByEmail(String email) {
        return userSummaryRepository.getByEmail(email);
    }

    public UserSummary getUserSummaryByAccessToken(String accessToken) {
        return  userSummaryRepository.getByAccessToken(accessToken);
    }

    public void saveUser(UserSummary userSummary) {
        userSummaryRepository.saveAndFlush(userSummary);
    }
}
