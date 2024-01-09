package com.ssdam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@EnableJpaAuditing
@SpringBootApplication
public class SsDamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsDamApplication.class, args);
    }

}
