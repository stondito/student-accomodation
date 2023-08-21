package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.services.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;
}
