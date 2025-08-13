package com.schedule.Lv6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv6ScheduleAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(Lv6ScheduleAppApplication.class, args);
    }

}
