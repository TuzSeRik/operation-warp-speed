package com.ncproject.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.time.Instant;
import com.ncproject.backend.repositories.UserRepository;
import com.ncproject.backend.model.User;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    User getUserById(UUID id) {
        return userRepository.getOne(id);
    }

    User getUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    void addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            if (userRepository.getByEmail(user.getEmail()).getExpiresAt().isBefore(Instant.now())) {
                userRepository.delete(user);
                userRepository.save(user);
            }
        }
        else {
            userRepository.save(user);
        }
    }
}
