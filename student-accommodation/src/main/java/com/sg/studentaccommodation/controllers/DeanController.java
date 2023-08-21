package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.services.DeanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DeanController {
    private final DeanService deanService;
}
