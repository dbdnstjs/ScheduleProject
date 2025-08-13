package com.schedule.Lv4.controller;

import com.schedule.Lv4.dto.ScheduleRequestDto;
import com.schedule.Lv4.dto.ScheduleResponseDto;
import com.schedule.Lv4.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//restful api 구현
@RestController//JSON 반환
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto request) {
        return ResponseEntity.ok(scheduleService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules() {
        return ResponseEntity.ok(scheduleService.findSchedules());
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> getScheduleId(@PathVariable("scheduleId") Long scheduleId) {
        return ResponseEntity.ok(scheduleService.findById(scheduleId));
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable("scheduleId") Long scheduleId, @RequestBody ScheduleRequestDto request) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, request));
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("scheduleId") Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok("일정 삭제 성공");
    }
}
