package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.services.RectorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RectorController {
    private final RectorService rectorService;
}
