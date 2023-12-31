package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.objects.Sex;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    private String firstName;

    private String LastName;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotBlank
    private String password;
}
