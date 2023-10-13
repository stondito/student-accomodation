package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.services.dao.HostDao;
import com.sg.studentaccommodation.services.dto.BlockServiceDto;
import com.sg.studentaccommodation.services.dto.impl.HostServiceDtoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HostServiceDtoTest {
    @Mock
    private HostDao dao;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private BlockServiceDto blockServiceDto;

    @InjectMocks
    private HostServiceDtoImpl service;

    @Test
    public void testRetrieveHost() {
        HostDtoIn in = new HostDtoIn();
        Host host = new Host();
        HostDtoOut hostDtoOut = new HostDtoOut();

        when(dao.retrieveHost(in)).thenReturn(host);
        when(modelMapper.map(host, HostDtoOut.class)).thenReturn(hostDtoOut);

        service.retrieveHost(in);

        verify(dao, times(1)).retrieveHost(in);
        verify(modelMapper, times(1)).map(host, HostDtoOut.class);

    }

    @Test
    public void testCheckIfExistById() {
        service.checkIfExistById(1L);

        verify(dao, times(1)).checkIfExistById(1L);
    }

    @Test
    public void testAppoint() {
        Block saved = new Block();
        Host appointed = new Host();
        HostDtoOut out = new HostDtoOut();

        when(blockServiceDto.getBlockByID(1L)).thenReturn(saved);
        when(dao.appoint(2L, saved)).thenReturn(appointed);
        when(modelMapper.map(appointed, HostDtoOut.class)).thenReturn(out);

        service.appoint(2L, 1L);

        verify(blockServiceDto, times(1)).getBlockByID(1L);
        verify(dao, times(1)).appoint(2L, saved);
        verify(modelMapper, times(1)).map(appointed, HostDtoOut.class);
    }
}
