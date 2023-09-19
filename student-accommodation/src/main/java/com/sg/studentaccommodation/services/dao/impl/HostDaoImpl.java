package com.sg.studentaccommodation.services.dao.impl;


import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.repos.HostRepo;
import com.sg.studentaccommodation.services.dao.HostDao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class HostDaoImpl implements HostDao {
    private final HostRepo hostRepo;
    private final ModelMapper modelMapper;

    public Host registerHost(HostDtoIn hostDtoIn) {
        Host host = modelMapper.map(hostDtoIn, Host.class);

        return this.hostRepo.save(host);
    }

    // todo custom exception
    @Override
    public Host retrieveHost(HostDtoIn hostDtoIn) {

        return this.hostRepo.
                findByUsernameAndPassword(hostDtoIn.getUsername(), hostDtoIn.getPassword())
                .orElseThrow(RuntimeException::new);
    }

    // todo custom exception
    @Override
    public Host getHostById(Long id) {
        return this.hostRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    public boolean checkIfExistById(Long id) {
        return this.hostRepo.existsById(id);
    }
}
