package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.repos.HostRepo;
import com.sg.studentaccommodation.services.dao.impl.HostDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HostDaoTest {
    @Mock
    private HostRepo repo;
    @Mock
    private ModelMapper mapper;
    @Mock
    Host hostMocked = new Host();

    @InjectMocks
    private HostDaoImpl dao;

    @Test
    public void shouldRegisterHost() {
        Host returned = new Host();
        HostDtoIn hostDtoIn = new HostDtoIn();

        when(repo.save(returned)).thenReturn(returned);
        when(mapper.map(hostDtoIn, Host.class)).thenReturn(returned);

        dao.registerHost(hostDtoIn);

        verify(mapper, times(1)).map(hostDtoIn, Host.class);
        verify(repo, times(1)).save(returned);
    }

    @Test
    public void shouldRetrieveHost() {
        Host returned = new Host();
        HostDtoIn hostDtoIn = new HostDtoIn();
        hostDtoIn.setUsername("username");
        hostDtoIn.setPassword("password");

        when(repo.findByUsernameAndPassword(hostDtoIn.getUsername(), hostDtoIn.getPassword())).thenReturn(Optional.of(returned));

        dao.retrieveHost(hostDtoIn);

        verify(repo, times(1)).findByUsernameAndPassword(hostDtoIn.getUsername(), hostDtoIn.getPassword());
    }

    @Test
    public void shouldGtHostById() {
        Host returned = new Host();
        when(repo.findById(1L)).thenReturn(Optional.of(returned));

        dao.getHostById(1L);

        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void shouldCheckIfExistById() {
        when(repo.existsById(1L)).thenReturn(true);

        dao.checkIfExistById(1L);

        verify(repo, times(1)).existsById(1L);
    }

    @Test
    public void shouldAppoint() {
        Block block = new Block();

        when(hostMocked.getId()).thenReturn(1L);
        when(repo.findById(hostMocked.getId())).thenReturn(Optional.of(hostMocked));

        dao.appoint(hostMocked.getId(), block);


        verify(repo, times(1)).findById(hostMocked.getId());
        verify(hostMocked, times(1)).setBlock(block);
    }


}
