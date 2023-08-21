package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.services.HostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HostController {
    private final HostService hostService;
}
