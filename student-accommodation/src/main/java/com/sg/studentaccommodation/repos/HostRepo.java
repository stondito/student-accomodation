package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.people.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HostRepo extends JpaRepository<Host, Long> {
    Optional<Host> findByUsernameAndPassword(String username, String Password);
}
