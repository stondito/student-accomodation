package com.sg.studentaccommodation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StudentAccommodationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentAccommodationApplication.class, args);
    }

}
