package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.services.dao.RoomDao;
import com.sg.studentaccommodation.services.dto.impl.RoomServiceDtoImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomServiceDtoTest {

    private String exMessage = "there are no free beds";
    @Mock
    private RoomDao dao;

    @Mock
    private ModelMapper mapper;
    @Mock
    private Room roomMock;

    @InjectMocks
    private RoomServiceDtoImpl service;

    @Test
    public void testAddStudentInRoom() {
        Room room = new Room();
        room.setNumberOfBeds(3);

        RoomDto dto = new RoomDto();

        StudentDtoIn in = new StudentDtoIn();

        when(dao.getRoom(1L)).thenReturn(room);
        when(dao.addStudentInRoom(in, room)).thenReturn(room);
        when(mapper.map(room, RoomDto.class)).thenReturn(dto);

        service.addStudentInRoom(in, 1L);

        verify(dao, times(1)).getRoom(1L);
        verify(dao, times(1)).addStudentInRoom(in, room);
        verify(mapper,times(1)).map(room, RoomDto.class);
    }

    @Disabled
    @Test
    public void testFailAddStudentInRoom() {
        // todo test custom exception

        when(dao.getRoom(1L)).thenReturn(roomMock);
        when(roomMock.getStudents()).thenReturn(List.of(new Student()));
        when(roomMock.getNumberOfBeds()).thenReturn(0);

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.addStudentInRoom(new StudentDtoIn(), 1L));

        assertEquals(ex.getMessage(), exMessage);
    }

    @Test
    public void testSaveRoom() {
        Room room = new Room();
        service.saveRoom(room);

        verify(dao, times(1)).saveRoom(room);
    }

    @Test
    public void testFindFreeRoomsCase1() {
        Room r1 = new Room();
        Room r2 = new Room();

        RoomDto dto1 = new RoomDto();
        RoomDto dto2 = new RoomDto();

        List<Room> free = List.of(r1, r2);

        when(dao.findFreeRooms(1L)).thenReturn(free);
        free.forEach(r->
                when(mapper.map(r, RoomDto.class)).thenReturn(dto1, dto2)
        );

        service.findFreeRooms(1L, Sex.Male);

        verify(dao).findFreeRooms(1L);
        free.forEach(r ->
            verify(mapper).map(r, RoomDto.class)
        );
    }

    @Test
    public void testFindFreeRoomsCase2() {
        Room r1 = new Room();
        Room r2 = new Room();

        Student s1 = new Student();
        s1.setSex(Sex.Male);
        Student s2 = new Student();
        s2.setSex(Sex.Male);

        r1.setStudents(List.of(s1));
        r2.setStudents(List.of(s2));

        RoomDto dto1 = new RoomDto();
        RoomDto dto2 = new RoomDto();

        List<Room> free = List.of(r1, r2);

        when(dao.findFreeRooms(1L)).thenReturn(free);
        free.forEach(r->
                when(mapper.map(r, RoomDto.class)).thenReturn(dto1, dto2)
        );

        service.findFreeRooms(1L, Sex.Male);

        verify(dao).findFreeRooms(1L);
        free.forEach(r ->
                verify(mapper).map(r, RoomDto.class)
        );
    }

}
