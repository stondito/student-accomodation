package com.sg.studentaccommodation.entities.people;

import com.sg.studentaccommodation.entities.objects.Sex;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Person {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String LastName;

    @Enumerated(EnumType.STRING)
    private Sex sex;
}
