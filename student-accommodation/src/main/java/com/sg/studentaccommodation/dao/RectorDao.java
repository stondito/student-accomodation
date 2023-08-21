package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.people.Rector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RectorDao extends JpaRepository<Rector, Long> {
}
