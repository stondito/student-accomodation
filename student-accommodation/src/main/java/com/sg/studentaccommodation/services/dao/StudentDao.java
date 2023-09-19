package com.sg.studentaccommodation.services.dao;


import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.entities.people.Student;

public interface StudentDao {
    Student retrieveUser(StudentDtoIn student);

    Student registerUser(StudentDtoIn student);
}
