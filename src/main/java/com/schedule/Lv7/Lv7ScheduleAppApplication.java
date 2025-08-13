package com.schedule.Lv7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv7ScheduleAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(Lv7ScheduleAppApplication.class, args);
    }

}
