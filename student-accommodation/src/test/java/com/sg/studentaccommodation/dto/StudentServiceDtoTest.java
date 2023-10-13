package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.services.dao.HostDao;
import com.sg.studentaccommodation.services.dao.StudentDao;
import com.sg.studentaccommodation.services.dto.ComplainServiceDto;
import com.sg.studentaccommodation.services.dto.impl.StudentServiceDtoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceDtoTest {
    private String exMessage = "no room number in block found";
    @Mock
    private StudentDao dao;
    @Mock
    private ModelMapper mapper;
    @Mock
    private HostDao hostDao;
    @Mock
    private ComplainServiceDto complainServiceDto;

    @InjectMocks
    private StudentServiceDtoImpl service;

    @Test
    public void testRetrieveUser() {
        StudentDtoIn in = new StudentDtoIn();
        Student student = new Student();
        StudentDtoOut out = new StudentDtoOut();

        when(dao.retrieveUser(in)).thenReturn(student);
        when(mapper.map(student, StudentDtoOut.class)).thenReturn(out);

        service.retrieveUser(in);

        verify(dao, times(1)).retrieveUser(in);
        verify(mapper, times(1)).map(student, StudentDtoOut.class);
    }

    @Test
    public void testRegisterUser() {
        StudentDtoIn in = new StudentDtoIn();
        Student student = new Student();
        StudentDtoOut out = new StudentDtoOut();

        when(dao.registerUser(in)).thenReturn(student);
        when(mapper.map(student, StudentDtoOut.class)).thenReturn(out);

        service.registerUser(in);

        verify(dao, times(1)).registerUser(in);
        verify(mapper, times(1)).map(student, StudentDtoOut.class);
    }

    @Test
    public void testAddHost() {
        HostDtoIn in = new HostDtoIn();
        Student student = new Student();
        StudentDtoOut out = new StudentDtoOut();
        Host host = new Host();

        when(dao.getById(1L)).thenReturn(student);
        when(hostDao.registerHost(in)).thenReturn(host);
        when(mapper.map(student, StudentDtoOut.class)).thenReturn(out);

        service.addHost(in, 1L);

        verify(dao, times(1)).getById(1L);
        verify(hostDao, times(1)).registerHost(in);
        verify(mapper, times(1)).map(student, StudentDtoOut.class);
    }

    @Test
    public void testGetStudent() {
        Student student = new Student();
        StudentDtoOut out = new StudentDtoOut();

        when(dao.getById(1L)).thenReturn(student);
        when(mapper.map(student, StudentDtoOut.class)).thenReturn(out);

        service.getStudent(1L);

        verify(dao, times(1)).getById(1L);
        verify(mapper, times(1)).map(student, StudentDtoOut.class);
    }

    @Test
    public void testMakeComplain() {
        Room room = new Room();
        Block block = new Block();
        room.setBlock(block);
        room.setRoomNumber(1);

        Student student = new Student();
        room.setStudents(List.of(student));
        student.setRoom(room);
        block.setRooms(List.of(room));

        when(dao.getById(2L)).thenReturn(student);

        service.makeComplain(1, 2L, "noise");

        verify(dao, times(1)).getById(2L);

    }

    @Test
    public void testMakeComplainFail() {
        Room room = new Room();
        Block block = new Block();
        room.setBlock(block);
        room.setRoomNumber(1);

        Student student = new Student();
        room.setStudents(List.of(student));
        student.setRoom(room);
        block.setRooms(List.of(room));

        when(dao.getById(2L)).thenReturn(student);

        RuntimeException exception = assertThrows(RuntimeException.class,()->
                service.makeComplain(10, 2L, "noise"));

        assertEquals(exMessage, exception.getMessage());
    }

    @Test
    public void testRequestAccommodate() {
        Student student = new Student();
        StudentDtoOut out = new StudentDtoOut();

        when(dao.getById(1L)).thenReturn(student);
        when(mapper.map(student, StudentDtoOut.class)).thenReturn(out);

        StudentDtoOut result = service.requestAccommodate(1L);

        verify(dao, times(1)).getById(1L);
        verify(mapper, times(1)).map(student, StudentDtoOut.class);
    }

    @Test
    public void testFindNewStudents() {
        Student student = new Student();
        Page<Student> dtoOuts = new PageImpl<>(List.of(student));
        StudentDtoOut studentDtoOut = new StudentDtoOut();

        when(dao.findNEwStatusStudents(PageRequest.of(0,2))).thenReturn(dtoOuts);

        dao.findNEwStatusStudents(PageRequest.of(0,2));

        verify(dao).findNEwStatusStudents(PageRequest.of(0,2));
    }
}
