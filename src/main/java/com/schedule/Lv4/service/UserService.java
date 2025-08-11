package com.schedule.Lv4.service;

import com.schedule.Lv4.dto.UserRequestDto;
import com.schedule.Lv4.dto.UserResponseDto;
import com.schedule.Lv4.entity.User;
import com.schedule.Lv4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserRequestDto request) {
        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        User saveUser = userRepository.save(user);

        return new UserResponseDto(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getEmail(),
                saveUser.getCreatedAt(),
                saveUser.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        )).toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule with id " + id + " not found")
        );
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("user with id " + id + " not found")
        );

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("passwords don't match");
        }

        user.updateUser(request.getName(), request.getEmail());
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Transactional
    public void deleteUser(Long id, UserRequestDto request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("user with id " + id + " not found")
        );

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("passwords don't match");
        }

        userRepository.delete(user);
    }
}
