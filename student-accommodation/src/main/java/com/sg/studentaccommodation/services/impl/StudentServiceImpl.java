package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.StudentDao;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.services.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;
    private ModelMapper modelMapper;

    @Override
    public StudentDtoOut retrieveUser(StudentDtoIn student) {
        Student s = this.studentDao.findStudentByFnAndPassword(student.getFn(), student.getPassword())
                    .orElseThrow(() -> new RuntimeException("Can't find user"));

        return modelMapper.map(s, StudentDtoOut.class);
    }

    @Override
    public StudentDtoOut registerUser(StudentDtoIn student) {
        Student s = modelMapper.map(student, Student.class);
        s.setStatus(Status.New);
        s =  this.studentDao.save(s);


        return modelMapper.map(s, StudentDtoOut.class);
    }
}
