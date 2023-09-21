package com.sg.studentaccommodation.entities.people;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sg.studentaccommodation.entities.Complain;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fn;

    private String email;

    private String university;

    @Column(name = "year_of_studying")
    private int yearOfStudying;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "host_id")
    private Host host;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany
    private Set<Complain> made;

    @OneToMany
    private Set<Complain> recived;

    public void addComplain(Complain complain) {
        if (recived == null) {
            recived = new HashSet<>();
        }

        recived.add(complain);
    }

}
