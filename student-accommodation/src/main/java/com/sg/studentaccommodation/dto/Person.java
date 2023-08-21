package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.objects.Sex;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String LastName;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String password;
}
