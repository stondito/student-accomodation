package com.sg.studentaccommodation.services.dto;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;
import com.sg.studentaccommodation.entities.people.Host;

public interface HostServiceDto {
    HostDtoOut registerHost(HostDtoIn hostDtoIn);

    HostDtoOut retrieveHost(HostDtoIn hostDtoIn);

    HostDtoOut getHostById(Long id);

    boolean checkIfExistById(Long id);
}
