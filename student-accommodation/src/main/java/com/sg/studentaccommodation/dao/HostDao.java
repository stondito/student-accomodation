package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.people.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostDao extends JpaRepository<Host, Long> {
}
