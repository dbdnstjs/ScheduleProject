package com.schedule.Lv2.repository;

import com.schedule.Lv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
