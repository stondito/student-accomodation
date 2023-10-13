package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.StudentAccommodationApplication;
import com.sg.studentaccommodation.entities.people.AccommodationUser;
import com.sg.studentaccommodation.repos.AccommodationRepo;
import com.sg.studentaccommodation.services.dao.AccommodationDao;
import com.sg.studentaccommodation.services.dao.impl.AccommodationDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccommodationDaoTest {
    @Mock
    private AccommodationRepo repo;

    @InjectMocks
    private AccommodationDaoImpl dao;

    @Test
    public void shouldRetrieveAccommodationUser() {
        String username = "username";
        String password = "password";

        AccommodationUser accommodationUser = new AccommodationUser();
        accommodationUser.setUsername("username");
        accommodationUser.setPassword(password);
        when(repo.findAccommodationUserByUsernameAndPassword(username, password)).thenReturn(Optional.of(accommodationUser));

        dao.retrieveAccommodationUser(username, password);

        verify(repo, times(1)).findAccommodationUserByUsernameAndPassword(username, password);
    }
}