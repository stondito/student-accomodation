package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.services.dto.StudentServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentServiceDto studentService;

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

    @Transactional
    @PutMapping(path = "/student/{id}/addHost")
    public StudentDtoOut addHostInStudent(@RequestBody HostDtoIn hostDtoIn, @PathVariable Long id) {
        return this.studentService.addHost(hostDtoIn, id);
    }

    @GetMapping(path = "/student/get/{id}")
    public StudentDtoOut getStudent(@PathVariable(name = "id") Long id) {
        return this.studentService.getStudent(id);
    }
}
