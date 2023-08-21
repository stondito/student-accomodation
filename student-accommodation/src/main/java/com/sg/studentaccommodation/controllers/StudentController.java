package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
}
