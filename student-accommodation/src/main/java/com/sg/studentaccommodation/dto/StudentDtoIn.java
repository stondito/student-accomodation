package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.objects.Sex;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Getter
@Setter
public class StudentDtoIn {

    @NotBlank
    private String password;

    @NotNull
    private Integer fn;

    private String firstName;

    private String lastName;

    private Sex sex;

    private String university;

    private String email;

    @Override
    public String toString() {
        return "StudentDtoIn{" +
                "password='" + password + '\'' +
                ", fn=" + fn +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", university='" + university + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDtoIn that)) return false;
        return Objects.equals(password, that.password) && Objects.equals(fn, that.fn) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && sex == that.sex && Objects.equals(university, that.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, fn, firstName, lastName, sex, university);
    }
}
