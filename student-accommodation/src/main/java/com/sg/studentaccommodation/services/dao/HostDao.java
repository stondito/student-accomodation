package com.sg.studentaccommodation.services.dao;


import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;

public interface HostDao {
     HostDtoOut registerHost(HostDtoIn hostDtoIn);

     HostDtoOut retrieveHost(HostDtoIn hostDtoIn);
}
