package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.services.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private ModelMapper modelMapper;

    @PostMapping(path = "/student/login")
    public StudentDtoOut retrieveUser(@Validated @RequestBody StudentDtoIn student) {
        Student s = studentService.retrieveUser(student);
        StudentDtoOut studentDtoOut = modelMapper.map(s, StudentDtoOut.class);

        return studentDtoOut;
    }
}
