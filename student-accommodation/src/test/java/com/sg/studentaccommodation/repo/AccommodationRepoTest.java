package com.sg.studentaccommodation.repo;

import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.entities.people.AccommodationUser;
import com.sg.studentaccommodation.repos.AccommodationRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccommodationRepoTest {
    private final String username = "username";
    private final String password = "password";

    @Autowired
    private AccommodationRepo repo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void shouldSaveUser() {
        AccommodationUser user = new AccommodationUser();

        user.setSex(Sex.Male);
        user.setPassword(password);
        user.setUsername(username);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");

        AccommodationUser saved = repo.save(user);

        assertEquals(user.getSex(), saved.getSex());
        assertEquals(user.getPassword(), saved.getPassword());
        assertEquals(user.getUsername(), saved.getUsername());
        assertEquals(user.getFirstName(), saved.getFirstName());
        assertEquals(user.getLastName(), saved.getLastName());

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void shouldFindAccommodationUserByUsernameAndPassword() {
        AccommodationUser saved = repo.findAccommodationUserByUsernameAndPassword(username, password).get();

        assertNotNull(saved);

        repo.deleteById(saved.getId());

        assertThrows(Exception.class, () -> repo.findById(saved.getId()).orElseThrow(Exception::new));
    }
}
