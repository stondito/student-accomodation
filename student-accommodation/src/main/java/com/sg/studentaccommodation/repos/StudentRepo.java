package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByFnAndPassword(int fn, String password);

    Page<Student> findStudentsByStatus(Status status, Pageable pageable);
}
