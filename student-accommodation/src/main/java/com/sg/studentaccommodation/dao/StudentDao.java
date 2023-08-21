package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.people.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByFnAndPassword(int fn, String password);
}
