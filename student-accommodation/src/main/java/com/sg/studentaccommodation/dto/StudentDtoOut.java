package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Host;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDtoOut extends Person{

    private long id;

    private int fn;

    private String email;

    private int yearOfStudying;

    private Status status;

    private Host host;

    private Room room;

}
