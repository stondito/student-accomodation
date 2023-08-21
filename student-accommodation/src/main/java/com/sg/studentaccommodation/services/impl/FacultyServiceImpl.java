package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.FacultyDao;
import com.sg.studentaccommodation.services.FacultyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private final FacultyDao facultyDao;
}
