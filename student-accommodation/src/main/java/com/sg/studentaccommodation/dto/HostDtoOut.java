package com.sg.studentaccommodation.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sg.studentaccommodation.entities.objects.Sex;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public final class HostDtoOut {
    private long id;

    private String firstName;

    private String LastName;

    private Sex sex;

    private String password;

    @Temporal(TemporalType.DATE) // Specify the temporal type
    @DateTimeFormat(pattern = "dd/MM/yyyy") // Specify the date format
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Date dateOfEntrance;

    private String username;

    public HostDtoOut() {
    }
}
