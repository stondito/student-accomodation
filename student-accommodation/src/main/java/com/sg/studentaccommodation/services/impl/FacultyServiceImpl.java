package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.FacultyDao;
import com.sg.studentaccommodation.services.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyDao facultyDao;
}
