package com.schedule.Lv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv1ScheduleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lv1ScheduleAppApplication.class, args);
    }

}
