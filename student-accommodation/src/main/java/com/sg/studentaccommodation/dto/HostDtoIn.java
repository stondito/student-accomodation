package com.sg.studentaccommodation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Getter
@Setter
public final class HostDtoIn extends Person {
    private Date dataPfEntrance;

    @NotBlank
    private String username;
    @Override
    public String toString() {
        return "HostDtoIn{" +
                "dataPfEntrance=" + dataPfEntrance +" "+
                "firstName=" + this.getFirstName() +" "+
                "lastName=" + this.getLastName() +" "+
                "sex=" + this.getSex() +" "+
                "password=" + this.getPassword() +" "+
                "username="+ this.username + " "+
                '}';
    }
}
