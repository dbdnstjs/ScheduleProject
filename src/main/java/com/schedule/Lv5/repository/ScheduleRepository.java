package com.schedule.Lv5.repository;

import com.schedule.Lv5.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    default Schedule findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                ()->new IllegalArgumentException("Schedule with id " + id + " not found")
        );
    }
}
