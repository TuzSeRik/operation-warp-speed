package com.ncproject.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.ncproject.backend.model.UserSummary;

public interface UserSummaryRepository extends JpaRepository<UserSummary, UUID> {
    boolean existsByEmail(String email);
    UserSummary getByEmail(String email);
    UserSummary getByAccessToken(String accessToken);
}
