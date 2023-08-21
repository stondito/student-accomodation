package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyDao extends JpaRepository<Faculty, Long> {
}
