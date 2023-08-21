package com.sg.studentaccommodation.entities.people;


import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.entities.objects.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
