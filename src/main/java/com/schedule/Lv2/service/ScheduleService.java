package com.schedule.Lv2.service;


import com.schedule.Lv2.dto.ScheduleRequestDto;
import com.schedule.Lv2.dto.ScheduleResponseDto;
import com.schedule.Lv2.entity.Schedule;
import com.schedule.Lv2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//로직 설계
@Service
@RequiredArgsConstructor //final 필드 초기화하는 생성자
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getName(),
                request.getPassword()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getName(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(schedule -> new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        )).toList();
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule with id " + id + " not found")
        );
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule with id " + id + " not found")
        );

        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        schedule.updateSchedule(request.getTitle(),request.getContent(),request.getName());
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }

    @Transactional
    public void deleteSchedule(Long id, ScheduleRequestDto request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule with id " + id + " not found")
        );

        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        scheduleRepository.delete(schedule);
    }
}
