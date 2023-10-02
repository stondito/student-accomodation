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

        StudentDtoOut studentDtoOut = this.studentService.registerUser(student);
        System.out.println(studentDtoOut);
        return studentDtoOut;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @Transactional
    @PutMapping(path = "/student/{id}/complain/{roomNumber}")
    public boolean makeComplain(@PathVariable(name = "roomNumber") int roomNumber
                                , @PathVariable(name = "id") Long id
                                , @RequestBody String reason) {
        System.out.println("id: " + id + " room "+ roomNumber + " reason " + reason);
        return this.studentService.makeComplain(roomNumber, id, reason);
    }

    @Transactional
    @PutMapping(path = "/student/{id}/request/accommodation")
    public StudentDtoOut requestAccommodation(@PathVariable(name = "id") Long id){
        return this.studentService.requestAccommodate(id);
    }

}
