package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.people.Dean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeanDao extends JpaRepository<Dean, Long> {
}
