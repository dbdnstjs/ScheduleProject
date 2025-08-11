package com.schedule.Lv4.repository;

import com.schedule.Lv4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
