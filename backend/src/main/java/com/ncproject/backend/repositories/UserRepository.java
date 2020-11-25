package com.ncproject.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.ncproject.backend.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    User getByEmail(String email);
}
