package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.dto.RoomDto;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.services.dao.RoomDao;
import com.sg.studentaccommodation.services.dto.RoomServiceDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public List<RoomDto> findFreeRooms(Long blockId, Sex sex) {
        return this.dao.findFreeRooms(blockId).stream().filter(r -> {
                    if (r.getStudents() == null || r.getStudents().isEmpty()) {
                        return true;
                    }
                    return r.getStudents().get(0).getSex().name().equalsIgnoreCase(sex.name());
                })
                .map(r -> this.mapper.map(r, RoomDto.class))
                .collect(Collectors.toList());
    }
}
