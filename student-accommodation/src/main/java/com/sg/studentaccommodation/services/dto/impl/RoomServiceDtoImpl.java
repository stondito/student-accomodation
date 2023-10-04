package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.dto.RoomDto;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.services.dao.RoomDao;
import com.sg.studentaccommodation.services.dto.RoomServiceDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RoomServiceDtoImpl implements RoomServiceDto {
    private final RoomDao dao;
    private final ModelMapper mapper;

    @Override
    public RoomDto addStudentInRoom(StudentDtoIn studentDtoIn, Long roomID) {

        Room room = dao.getRoom(roomID);

        if (room.getStudents().size() >= room.getNumberOfBeds()) {
            throw new RuntimeException("there are no free beds");
        }

        Room saved = dao.addStudentInRoom(studentDtoIn, room);

        RoomDto roomDto = mapper.map(saved, RoomDto.class);

        return roomDto;
    }

    @Override
    public void saveRoom(Room room) {
        this.dao.saveRoom(room);
    }
}
