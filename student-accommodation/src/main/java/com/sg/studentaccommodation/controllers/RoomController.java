package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.RoomDto;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.services.dto.RoomServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RoomController {

    private final RoomServiceDto service;

    @Transactional
    @PostMapping(path = "/room/{id}/add/student")
    public RoomDto addStudentInRoom(@RequestBody StudentDtoIn studentDtoIn, @PathVariable Long id) {
        return service.addStudentInRoom(studentDtoIn, id);
    }
}
