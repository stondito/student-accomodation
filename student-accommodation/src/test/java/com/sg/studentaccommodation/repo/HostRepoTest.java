package com.sg.studentaccommodation.repo;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.repos.BlockRepo;
import com.sg.studentaccommodation.repos.HostRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HostRepoTest {

    private final String username = "username";
    private final String password = "password";
    @Autowired
    private HostRepo repo;
    @Autowired
    private BlockRepo blockRepo;


    @Test
    @Order(1)
    public void testShouldAddHost() {
        Host host = new Host();

        host.setUsername(username);
        host.setSex(Sex.Male);
        host.setPassword(password);
        host.setFirstName("Ivan");
        host.setLastName("Ivanov");

        Host saved = repo.saveAndFlush(host);

        assertEquals(host.getUsername(), saved.getUsername());
        assertEquals(host.getSex(), saved.getSex());
        assertEquals(host.getPassword(), saved.getPassword());
        assertEquals(host.getFirstName(), saved.getFirstName());
        assertEquals(host.getLastName(), saved.getLastName());

    }

    @Test
    @Order(2)
    public void shouldFindByUsernameAndPassword() {
        Host host = new Host();

        host.setUsername(username);
        host.setSex(Sex.Male);
        host.setPassword(password);
        host.setFirstName("Ivan");
        host.setLastName("Ivanov");

        Host saved = repo.saveAndFlush(host);

        Host found = repo.findById(saved.getId()).get();

        assertNotNull(found);

        repo.deleteById(found.getId());

        assertThrows(Exception.class, () -> repo.findById(host.getId()).orElseThrow(Exception::new));
    }

    @Test
    @Order(3)
    public void shouldAppointHost() {
        Host host = new Host();

        host.setUsername(username);
        host.setSex(Sex.Male);
        host.setPassword(password);
        host.setFirstName("Ivan");
        host.setLastName("Ivanov");

        Host savedHost = repo.save(host);

        Block block = new Block();
        block.setNumber(1);
        block.setHost(host);

        host.setBlock(block);

        Block savedBlock = blockRepo.save(block);

        // host
        assertEquals(host.getUsername(), savedHost.getUsername());
        assertEquals(host.getSex(), savedHost.getSex());
        assertEquals(host.getPassword(), savedHost.getPassword());
        assertEquals(host.getFirstName(), savedHost.getFirstName());
        assertEquals(host.getLastName(), savedHost.getLastName());

        // block
        assertEquals(block.getNumber(), savedBlock.getNumber());
        assertEquals(block.getHost().getId(), savedHost.getId());

    }
}
