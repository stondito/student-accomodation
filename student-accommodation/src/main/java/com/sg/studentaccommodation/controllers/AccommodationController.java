package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.AccommodationUserDtoIn;
import com.sg.studentaccommodation.entities.people.AccommodationUser;
import com.sg.studentaccommodation.services.dao.AccommodationDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccommodationController {
    private final AccommodationDao service;

    @PostMapping(path = "accommodation/login")
    public AccommodationUser getUser(@RequestBody AccommodationUserDtoIn in) {
        return this.service.retrieveAccommodationUser(in.getUsername(), in.getPassword());
    }
}
