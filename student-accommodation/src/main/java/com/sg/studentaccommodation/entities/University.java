package com.sg.studentaccommodation.entities;

import com.sg.studentaccommodation.entities.people.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "university")
    private Set<Faculty> faculties;

    @OneToMany(mappedBy = "university")
    private Set<Student> student;
}
