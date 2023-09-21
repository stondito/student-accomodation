package com.sg.studentaccommodation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sg.studentaccommodation.entities.people.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;


@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int floor;

    private int roomNumber;

    @Column(name="number_of_beds")
    private int numberOfBeds;

    @JsonManagedReference
    @OneToMany(mappedBy = "room", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Student> students;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "block_id")
    private Block block;

    public void addStudent(Student student) {
        if(students == null) {
            students = new LinkedList<>();
        }
        students.add(student);
    }
}
