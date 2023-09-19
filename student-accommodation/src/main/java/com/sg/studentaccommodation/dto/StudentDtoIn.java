package com.sg.studentaccommodation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.util.Objects;

@Getter
@Setter
public final class StudentDtoIn extends Person {

    @NotNull
    private Integer fn;

    private String university;

    @Email
    private String email;

    @Override
    public String toString() {
        return "StudentDtoIn{" +
                "password='" + getPassword() + '\'' +
                ", fn=" + fn +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", sex=" + getSex() +
                ", university='" + university + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDtoIn that)) return false;
        return Objects.equals(getPassword(), that.getPassword()) && Objects.equals(fn, that.fn) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && getSex() == that.getSex() && Objects.equals(university, that.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), fn, getFirstName(), getLastName(), getSex(), university);
    }
}
