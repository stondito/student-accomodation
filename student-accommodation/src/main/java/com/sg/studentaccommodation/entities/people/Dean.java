package com.sg.studentaccommodation.entities.people;

import com.sg.studentaccommodation.entities.Faculty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Dean extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;

    @OneToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
