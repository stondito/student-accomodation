package com.sg.studentaccommodation.services.dao;


import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;
import com.sg.studentaccommodation.entities.people.Host;

public interface HostDao {
     HostDtoOut registerHost(HostDtoIn hostDtoIn);

     HostDtoOut retrieveHost(HostDtoIn hostDtoIn);

     Host getHostById(Long id);
     boolean checkIfExistById(Long id);
}
