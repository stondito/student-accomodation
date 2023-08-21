package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.StudentDao;
import com.sg.studentaccommodation.services.StudentService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;
}
