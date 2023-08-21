package com.sg.studentaccommodation.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentDtoIn {

    @NotBlank
    private String password;

    private int fn;
}
