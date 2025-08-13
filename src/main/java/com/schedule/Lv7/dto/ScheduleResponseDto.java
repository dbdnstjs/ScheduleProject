package com.schedule.Lv7.dto;

//응답하는 데이터 서버 -> 클라

import com.schedule.Lv7.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //DTO 필드 초기화
    private ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

    // 이 메서드를 이용해 DTO 객체 생성
    public static ScheduleResponseDto of(Schedule schedule) {
        return new ScheduleResponseDto(schedule);
    }
}
