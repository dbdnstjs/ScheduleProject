package com.schedule.Lv3.repository;

import com.schedule.Lv3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
