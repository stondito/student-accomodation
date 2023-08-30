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
public final class HostServiceImpl implements HostDao {
    private final HostRepo hostDao;
    private final ModelMapper modelMapper;

    public HostDtoOut registerHost(HostDtoIn hostDtoIn) {
        Host host = modelMapper.map(hostDtoIn, Host.class);

        this.hostDao.save(host);

        HostDtoOut hostDtoOut = modelMapper.map(host, HostDtoOut.class);

        return hostDtoOut;
    }

    // todo custom exception
    @Override
    public HostDtoOut retrieveHost(HostDtoIn hostDtoIn) {
        Host host = this.hostDao.
                    findByUsernameAndPassword(hostDtoIn.getUsername(), hostDtoIn.getPassword())
                    .orElseThrow(RuntimeException::new);

        HostDtoOut hostDtoOut = modelMapper.map(host, HostDtoOut.class);

        return hostDtoOut;
    }
}
