package com.sg.studentaccommodation.entities;

import com.sg.studentaccommodation.entities.people.Host;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "host_id")
    private Host host;
}
