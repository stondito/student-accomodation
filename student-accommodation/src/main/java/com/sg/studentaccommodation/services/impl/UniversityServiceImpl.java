package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.UniversityDao;
import com.sg.studentaccommodation.entities.University;
import com.sg.studentaccommodation.services.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityDao universityDao;
    @Override
    public University get() {
        return null;
    }
}
