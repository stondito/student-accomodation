package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.people.AccommodationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccommodationRepo extends JpaRepository<AccommodationUser, Long> {
    Optional<AccommodationUser> findAccommodationUserByUsernameAndPassword(String username, String password);
}
