package com.schedule.Lv7.repository;

import com.schedule.Lv7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    default User findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                ()->new IllegalArgumentException("User with id " + id + " not found")
        );
    }
}
