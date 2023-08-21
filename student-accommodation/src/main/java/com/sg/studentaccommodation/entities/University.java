package com.sg.studentaccommodation.entities;

import com.sg.studentaccommodation.entities.people.Rector;
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

    @ManyToOne
    @JoinColumn(name = "rector_id")
    private Rector rector;

    @OneToMany(mappedBy = "university")
    private Set<Faculty> faculties;

}
