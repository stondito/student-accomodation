package com.sg.studentaccommodation.services.dao.impl;


import com.sg.studentaccommodation.repos.FacultyRepo;
import com.sg.studentaccommodation.services.dao.FacultyDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class FacultyDaoImpl implements FacultyDao {
    private final FacultyRepo facultyDao;
}
