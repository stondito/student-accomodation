package com.sg.studentaccommodation.entities.people;

import com.sg.studentaccommodation.entities.University;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Rector extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;
    // professor, dr ...
    private String title;

    @OneToMany(mappedBy = "rector")
    private Set<University> universities;
}
