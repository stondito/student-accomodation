package com.sg.studentaccommodation.entities;

import com.sg.studentaccommodation.entities.people.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student from;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
