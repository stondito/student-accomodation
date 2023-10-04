package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.entities.people.AccommodationUser;
import com.sg.studentaccommodation.repos.AccommodationRepo;
import com.sg.studentaccommodation.services.dao.AccommodationDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccommodationDaoImpl implements AccommodationDao {
    private final AccommodationRepo repo;

    @Override
    public AccommodationUser retrieveAccommodationUser(String username, String password) {
        return this.repo
                .findAccommodationUserByUsernameAndPassword(username, password).orElseThrow(RuntimeException::new);
    }
}
