package com.sg.studentaccommodation.entities;

import com.sg.studentaccommodation.entities.people.Student;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int floor;

    @Column(name="number_of_beds")
    private int numberOfBeds;

    @OneToMany(mappedBy = "room")
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
}
