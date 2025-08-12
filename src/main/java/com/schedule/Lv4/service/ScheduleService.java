package com.schedule.Lv4.service;


import com.schedule.Lv4.dto.ScheduleRequestDto;
import com.schedule.Lv4.dto.ScheduleResponseDto;
import com.schedule.Lv4.entity.Schedule;
import com.schedule.Lv4.repository.ScheduleRepository;
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
        Schedule schedule = new Schedule(request.getTitle(), request.getContent());
        Schedule saveSchedule = scheduleRepository.save(schedule);
        //정적 팩토리 메서드 사용
        return ScheduleResponseDto.of(saveSchedule);
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        //정적 팩토리 메서드 레퍼런스 사용
        return schedules.stream().map(ScheduleResponseDto::of).toList();
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrThrow(id);
        return ScheduleResponseDto.of(schedule);
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto request) {
        Schedule schedule = scheduleRepository.findByIdOrThrow(id);
        schedule.updateSchedule(request.getTitle(), request.getContent());
        return ScheduleResponseDto.of(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrThrow(id);
        scheduleRepository.delete(schedule);
    }
}
