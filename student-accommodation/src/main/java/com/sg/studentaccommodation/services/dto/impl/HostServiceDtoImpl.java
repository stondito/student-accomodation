package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;
import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.services.dao.HostDao;
import com.sg.studentaccommodation.services.dto.BlockServiceDto;
import com.sg.studentaccommodation.services.dto.HostServiceDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HostServiceDtoImpl implements HostServiceDto {
    private final HostDao dao;
    private final ModelMapper modelMapper;
    private final BlockServiceDto blockServiceDto;
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

    @Override
    public boolean checkIfExistById(Long id) {
        return this.dao.checkIfExistById(id);
    }

    @Override
    public Long getBlockByHostId(Long id) {
        return this.dao.getHostById(id).getBlock().getId();
    }

    @Override
    public HostDtoOut appoint(Long id, Long blockId) {
        Block saved = this.blockServiceDto.getBlockByID(blockId);

        Host host = this.dao.appoint(id, saved);

        HostDtoOut hostDtoOut = this.modelMapper.map(host, HostDtoOut.class);

        return hostDtoOut;
    }

}
