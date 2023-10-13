package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.repos.RoomRepo;
import com.sg.studentaccommodation.services.dao.StudentDao;
import com.sg.studentaccommodation.services.dao.impl.RoomDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomDaoTest {
    @Mock
    private RoomRepo repo;

    @Mock
    private StudentDao studentDao;

    @InjectMocks
    private RoomDaoImpl dao;


    @Test
    public void shouldAddStudentInRoom() {
        StudentDtoIn in = new StudentDtoIn();
        Student returned = new Student();

        when(studentDao.retrieveUser(in)).thenReturn(returned);

        Room room = new Room();

        dao.addStudentInRoom(in, room);

        verify(studentDao).retrieveUser(in);

        assertEquals(returned.getStatus(), Status.Accommodated);
        assertEquals(returned.getRoom(), room);
        assertEquals(room.getStudents().get(0), returned);
    }

    @Test
    public void shouldSaveRoom() {
        Room room = new Room();

        dao.saveRoom(room);

        verify(repo, times(1)).save(room);
    }
    @Test
    public void shouldFindFreeRooms() {
        dao.findFreeRooms(1L);

        verify(repo, times(1)).findFreeRooms(1L);
    }

    @Test
    public void shouldGetRoomById() {
        when(repo.findById(1L)).thenReturn(Optional.of(new Room()));

        dao.getRoom(1L);

        verify(repo, times(1)).findById(1L);
    }
}
