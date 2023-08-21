package com.sg.studentaccommodation.entities;

import com.sg.studentaccommodation.entities.people.Host;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    @OneToOne(mappedBy = "block")
    private Host host;

    // todo ManyToMany with rooms
    @OneToMany(mappedBy = "block")
    private List<Room> rooms;

}
