package com.schedule.Lv4.service;

import com.schedule.Lv4.dto.UserRequestDto;
import com.schedule.Lv4.dto.UserResponseDto;
import com.schedule.Lv4.entity.User;
import com.schedule.Lv4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserRequestDto request) {
        User user = new User(request.getEmail(), request.getName(), request.getPassword());
        User saveUser = userRepository.save(user);
        //정적 팩토리 메서드 레퍼런스 사용
        return UserResponseDto.of(saveUser);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findUsers() {
        List<User> users = userRepository.findAll();
        //정적 팩토리 메서드 레퍼런스 사용
        return users.stream().map(UserResponseDto::of).toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User user = userRepository.findByIdOrThrow(id);
        return UserResponseDto.of(user);
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto request) {
        User user = userRepository.findByIdOrThrow(id);

        if (!user.getPassword().equals(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "passwords don't match");
        }
        user.updateUser(request.getEmail(), request.getName());

        return UserResponseDto.of(user);
    }

    @Transactional
    public void deleteUser(Long id, UserRequestDto request) {
        User user = userRepository.findByIdOrThrow(id);

        if (!user.getPassword().equals(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "passwords don't match");
        }

        userRepository.delete(user);
    }
}
