package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.services.dao.HostDao;
import com.sg.studentaccommodation.services.dto.HostServiceDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HostServiceDtoImpl implements HostServiceDto {
    private final HostDao dao;
    private final ModelMapper modelMapper;
    @Override
    public HostDtoOut registerHost(HostDtoIn hostDtoIn) {
        Host saved = this.dao.registerHost(hostDtoIn);

        HostDtoOut hostDtoOut = modelMapper.map(saved, HostDtoOut.class);

        return hostDtoOut;
    }

    @Override
    public HostDtoOut retrieveHost(HostDtoIn hostDtoIn) {

        Host host = this.dao.retrieveHost(hostDtoIn);

        HostDtoOut hostDtoOut = modelMapper.map(host, HostDtoOut.class);

        return hostDtoOut;
    }

    @Override
    public HostDtoOut getHostById(Long id) {
        Host host = this.dao.getHostById(id);

        HostDtoOut hostDtoOut = modelMapper.map(host, HostDtoOut.class);

        return hostDtoOut;
    }

}
