package com.schedule.Lv4.service;

import com.schedule.Lv4.dto.AuthRequest;
import com.schedule.Lv4.dto.AuthResponse;
import com.schedule.Lv4.entity.User;
import com.schedule.Lv4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    @Transactional
    public void signup(AuthRequest request) {
        User user = new User(request.getEmail(), request.getPassword());
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("Invalid email address provided")
        );

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("passwords don't match");
        }

        return new AuthResponse(user.getId());
    }
}
