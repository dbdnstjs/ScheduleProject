package com.schedule.Lv2.controller;

import com.schedule.Lv2.dto.UserRequestDto;
import com.schedule.Lv2.dto.UserResponseDto;
import com.schedule.Lv2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//JSON 반환
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto request) {
        return ResponseEntity.ok(userService.save(request));
    }

    @PostMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getSchedule() {
        return ResponseEntity.ok(userService.findUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> getUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("userId") Long userId, @RequestBody UserRequestDto request) {
        return ResponseEntity.ok(userService.updateUser(userId, request));
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId, @RequestBody UserRequestDto request) {
        userService.deleteUser(userId, request);
    }
}
