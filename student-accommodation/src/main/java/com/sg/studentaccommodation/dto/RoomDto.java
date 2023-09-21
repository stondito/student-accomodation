package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Block;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoomDto {
    private long id;

    private int floor;

    private int roomNumber;

    private int numberOfBeds;
    private List<StudentDtoOut> students;

    private Block block;
}
