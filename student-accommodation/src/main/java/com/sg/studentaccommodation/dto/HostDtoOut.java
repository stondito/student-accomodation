package com.sg.studentaccommodation.dto;


import com.sg.studentaccommodation.entities.objects.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
    private Date dataPfEntrance;

    private String username;

    public HostDtoOut() {
    }
}
