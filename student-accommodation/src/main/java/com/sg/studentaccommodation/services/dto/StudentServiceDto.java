package com.sg.studentaccommodation.services.dto;

import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;

public interface StudentServiceDto {
    StudentDtoOut retrieveUser(StudentDtoIn student);

    StudentDtoOut registerUser(StudentDtoIn student);
}
