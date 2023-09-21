package com.sg.studentaccommodation.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sg.studentaccommodation.entities.people.Host;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    @OneToOne(mappedBy = "block")
    private Host host;

    @JsonManagedReference
    @OneToMany(mappedBy = "block", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Room> rooms;

}
