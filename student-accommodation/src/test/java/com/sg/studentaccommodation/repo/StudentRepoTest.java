package com.sg.studentaccommodation.repo;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.repos.BlockRepo;
import com.sg.studentaccommodation.repos.RoomRepo;
import com.sg.studentaccommodation.repos.StudentRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepoTest {
    private final String password = "password";
    private final Integer fn = 1234;
    @Autowired
    private StudentRepo repo;
    @Autowired
    private BlockRepo blockRepo;
    @Autowired
    private RoomRepo roomRepo;

    @Test
    @Rollback(value = false)
    @Order(1)
    public void shouldAddUser() {
        Student student = new Student();

        student.setStatus(Status.New);
        student.setPassword(password);
        student.setSex(Sex.Male);
        student.setFn(fn);
        student.setEmail("i@abv.bg");
        student.setFirstName("Иван");
        student.setLastName(("Иванов"));

        Student saved = repo.save(student);

        assertEquals(student.getStatus(), saved.getStatus());
        assertEquals(student.getPassword(), saved.getPassword());
        assertEquals(student.getSex(), saved.getSex());
        assertEquals(student.getFn(), saved.getFn());
        assertEquals(student.getEmail(), saved.getEmail());
        assertEquals(student.getFirstName(), saved.getFirstName());
        assertEquals(student.getLastName(), saved.getLastName());
    }

    @Test
    @Order(2)
    public void shouldFindStudentByFnAndPassword() {
        Student student = repo.findStudentByFnAndPassword(fn, password).get();

        assertNotNull(student);
    }

    @Test
    @Order(3)
    public void shouldFindStudentsByStatusNew() {
        Page<Student> page = repo.findStudentsByStatus(Status.New, PageRequest.of(0, 1));

        List<Student> list = page.getContent();

        assertNotNull(list.get(0));
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void shouldFailFindStudent() {
        Student student = repo.findStudentByFnAndPassword(fn, password).get();

        repo.deleteById(student.getId());

        assertThrows(Exception.class, () -> repo.findStudentByFnAndPassword(fn, password).orElseThrow(Exception::new));
    }

    @Test
    @Order(4)
    public void shouldAccommodateStudent() {
        Student student = repo.findStudentByFnAndPassword(fn, password).get();

        List<Room> rooms = List.of(new Room(), new Room());
        Block block = new Block();
        block.setNumber(1);
        block.setRooms(rooms);
        rooms.forEach((r) -> r.setBlock(block));

        Block saved = blockRepo.saveAndFlush(block);

        saved.getRooms().get(0).addStudent(student);
        student.setRoom(saved.getRooms().get(0));

        roomRepo.save(block.getRooms().get(0));
        roomRepo.save(block.getRooms().get(1));

        repo.flush();
        Student found = repo.findStudentByFnAndPassword(fn, password).get();

        assertNotNull(saved);
        assertEquals(block, saved);
        assertEquals(2, saved.getRooms().size());
        assertEquals(block.getRooms().get(0), found.getRoom());

    }
}
