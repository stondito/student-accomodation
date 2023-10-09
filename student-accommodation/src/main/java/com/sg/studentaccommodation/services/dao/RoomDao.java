package com.sg.studentaccommodation.services.dao;


import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Sex;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao {
    Room getRoom(Long id);

    Room addStudentInRoom(StudentDtoIn studentDtoIn, Room room);

    Room saveRoom(Room room);

    List<Room> findFreeRooms(Long blockId);
}
