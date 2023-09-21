package com.sg.studentaccommodation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student from;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
