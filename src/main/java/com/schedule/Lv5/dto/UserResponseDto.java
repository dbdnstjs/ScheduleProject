package com.schedule.Lv5.dto;

import com.schedule.Lv5.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }

    public static UserResponseDto of(User user) {
        return new UserResponseDto(user);
    }
}
