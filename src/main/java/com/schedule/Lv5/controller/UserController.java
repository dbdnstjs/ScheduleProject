package com.schedule.Lv5.controller;

import com.schedule.Lv5.dto.UserRequestDto;
import com.schedule.Lv5.dto.UserResponseDto;
import com.schedule.Lv5.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//JSON 반환
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getSchedule() {
        return ResponseEntity.ok(userService.findUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("userId") Long userId, @RequestBody @Valid UserRequestDto request) {
        return ResponseEntity.ok(userService.updateUser(userId, request));
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId, @RequestBody @Valid UserRequestDto request) {
        userService.deleteUser(userId, request);
        return "사용자 삭제 성공";
    }
}
