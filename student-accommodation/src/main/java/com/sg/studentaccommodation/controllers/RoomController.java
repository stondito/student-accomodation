package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;
}
