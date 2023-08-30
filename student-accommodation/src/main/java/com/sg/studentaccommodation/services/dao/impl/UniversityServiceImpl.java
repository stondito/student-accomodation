package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.entities.University;

import com.sg.studentaccommodation.repos.UniversityRepo;
import com.sg.studentaccommodation.services.dao.UniversityDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class UniversityServiceImpl implements UniversityDao {
    private final UniversityRepo universityDao;
    @Override
    public University get() {
        return null;
    }
}
