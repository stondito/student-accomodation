package com.sg.studentaccommodation.services.dao;


import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.Room;

import java.util.List;

public interface RoomDao {
    Room getRoom(Long id);

    Room addStudentInRoom(StudentDtoIn studentDtoIn, Room room);

    Room saveRoom(Room room);
}
