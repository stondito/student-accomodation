package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class StudentDtoOut extends Person{

    private long id;

    private int fn;

    private String email;

    private int yearOfStudying;

    private Status status;

    private String university;

    private Room room;

}
