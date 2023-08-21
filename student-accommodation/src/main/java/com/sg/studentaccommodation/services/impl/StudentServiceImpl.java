package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.StudentDao;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Override
    public Student retrieveUser(StudentDtoIn student) {
        return this.studentDao.findStudentByFnAndPassword(student.getFn(), student.getPassword())
                .orElseThrow(() -> new RuntimeException());
    }
}
