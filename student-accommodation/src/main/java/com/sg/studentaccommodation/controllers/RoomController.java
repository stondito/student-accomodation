package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.RoomDto;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.services.dto.RoomServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoomController {

    private final RoomServiceDto service;

    @Transactional
    @PostMapping(path = "/room/{id}/add/student")
    public RoomDto addStudentInRoom(@RequestBody StudentDtoIn studentDtoIn, @PathVariable Long id) {
        return service.addStudentInRoom(studentDtoIn, id);
    }

    @GetMapping(path = "/room/free/block/{id}")
    public List<RoomDto> getFreeRooms(@PathVariable(name = "id") Long id, @RequestParam(name = "sex") Sex sex) {
        return this.service.findFreeRooms(id, sex);
    }

}
