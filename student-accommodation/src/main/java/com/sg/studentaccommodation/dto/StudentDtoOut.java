package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Host;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDtoOut extends Person{

    private int fn;

    private String email;

    @Column(name = "year_of_studying")
    private int yearOfStudying;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
