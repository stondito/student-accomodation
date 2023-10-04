package com.sg.studentaccommodation.services.dao;

import com.sg.studentaccommodation.entities.people.AccommodationUser;

public interface AccommodationDao {
    AccommodationUser retrieveAccommodationUser(String username, String password);
}
