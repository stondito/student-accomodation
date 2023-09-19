package com.sg.studentaccommodation.dto;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public final class HostDtoIn extends Person {
    private Long id;

    @Temporal(TemporalType.DATE) // Specify the temporal type
    @DateTimeFormat(pattern = "dd/MM/yyyy") // Specify the date format
    private Date dateOfEntrance;

    @NotBlank
    private String username;
    @Override
    public String toString() {
        return "HostDtoIn{" +
                "dataPfEntrance=" + dateOfEntrance +" "+
                "firstName=" + this.getFirstName() +" "+
                "lastName=" + this.getLastName() +" "+
                "sex=" + this.getSex() +" "+
                "password=" + this.getPassword() +" "+
                "username="+ this.username + " "+
                '}';
    }
}
