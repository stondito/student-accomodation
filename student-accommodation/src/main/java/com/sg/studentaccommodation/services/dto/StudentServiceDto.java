package com.sg.studentaccommodation.services.dto;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.entities.people.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentServiceDto {
    StudentDtoOut retrieveUser(StudentDtoIn student);

    StudentDtoOut registerUser(StudentDtoIn student);

    StudentDtoOut addHost(HostDtoIn host, Long studentId);

    StudentDtoOut getStudent(Long id);

    boolean makeComplain( int roomNumber, Long id, String reason);

    StudentDtoOut requestAccommodate(Long id);

    Page<StudentDtoOut> findNewStatusStudents(Pageable pageable);
}
