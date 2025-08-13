package com.schedule.Lv5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv5ScheduleAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(Lv5ScheduleAppApplication.class, args);
    }

}
