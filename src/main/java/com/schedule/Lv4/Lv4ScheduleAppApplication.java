package com.schedule.Lv4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv4ScheduleAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(Lv4ScheduleAppApplication.class, args);
    }

}
