package com.sg.studentaccommodation.services.dao;


import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.entities.people.Student;

public interface StudentDao {
    StudentDtoOut retrieveUser(StudentDtoIn student);

    StudentDtoOut registerUser(StudentDtoIn student);
}
