package com.schedule.Lv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv3ScheduleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lv3ScheduleAppApplication.class, args);
    }

}
