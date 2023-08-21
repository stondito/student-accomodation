package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityDao extends JpaRepository<University, Long> {
}
