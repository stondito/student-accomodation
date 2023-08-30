package com.sg.studentaccommodation.entities.people;

import com.sg.studentaccommodation.entities.Block;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Host extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateOfEntrance;

    @OneToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @OneToMany(mappedBy = "host")
    private Set<Student> students;
}
