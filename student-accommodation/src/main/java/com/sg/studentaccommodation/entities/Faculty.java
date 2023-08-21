package com.sg.studentaccommodation.entities;

import com.sg.studentaccommodation.entities.people.Dean;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "faculty")
    private Dean dean;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
}
