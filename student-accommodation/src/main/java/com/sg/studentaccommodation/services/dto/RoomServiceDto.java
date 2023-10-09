package com.sg.studentaccommodation.services.dto;

import com.sg.studentaccommodation.dto.RoomDto;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Sex;

import java.util.List;

public interface RoomServiceDto {
    RoomDto addStudentInRoom(StudentDtoIn studentDtoIn, Long RoomID);

    void saveRoom(Room room);

    List<RoomDto> findFreeRooms(Long blockId, Sex sex);
}
