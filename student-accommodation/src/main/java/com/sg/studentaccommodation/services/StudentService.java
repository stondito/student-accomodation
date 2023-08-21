package com.sg.studentaccommodation.services;


import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.people.Student;

public interface StudentService {
    Student retrieveUser(StudentDtoIn student);
}
