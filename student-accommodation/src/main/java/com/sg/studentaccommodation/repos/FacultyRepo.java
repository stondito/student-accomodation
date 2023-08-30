package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {
}
