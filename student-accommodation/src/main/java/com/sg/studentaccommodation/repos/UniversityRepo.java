package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {
}
