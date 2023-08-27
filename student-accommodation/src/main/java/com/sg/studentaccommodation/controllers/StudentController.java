package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @PostMapping(path = "/student/login")
    public StudentDtoOut retrieveUser(@Validated @RequestBody StudentDtoIn student) {
        System.out.println("Hit:"+ student.getPassword() +"|" + student.getFn());

        return this.studentService.retrieveUser(student);
    }

    @PostMapping(path = "/student/register")
    public StudentDtoOut registerStudent(@RequestBody StudentDtoIn student) {
        System.out.println("Hit:"+ student);

        return this.studentService.registerUser(student);
    }
}
