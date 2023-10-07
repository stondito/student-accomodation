package com.sg.studentaccommodation.services.dao;


import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.entities.people.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentDao {
    Student retrieveUser(StudentDtoIn student);

    Student registerUser(StudentDtoIn student);

    Student getById(Long id);

    Page<Student> findNEwStatusStudents(Pageable pageable);
}
