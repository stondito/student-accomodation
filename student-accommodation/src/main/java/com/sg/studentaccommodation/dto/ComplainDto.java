package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.people.Student;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComplainDto {
    private String reason;

    private Student from;

    private Room room;
}
