package com.sg.studentaccommodation.services.dao;


import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;
import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.people.Host;

public interface HostDao {
     Host registerHost(HostDtoIn hostDtoIn);

     Host retrieveHost(HostDtoIn hostDtoIn);

     Host getHostById(Long id);
     boolean checkIfExistById(Long id);

     Host appoint(Long id, Block block);
}
