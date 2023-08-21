package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.services.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UniversityController {
    private final UniversityService universityService;
}
