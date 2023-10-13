package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.repos.BlockRepo;
import com.sg.studentaccommodation.services.dao.impl.BlockDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlockDaoTest {

    @Mock
    private BlockRepo repo;

    @InjectMocks
    private BlockDaoImpl dao;

    @Test
    public void shouldSaveTest() {
        Block saved = new Block();
        when(repo.save(saved)).thenReturn(saved);

        assertNotNull(repo);
        dao.saveBlock(saved);

        verify(repo, times(1)).save(saved);
    }

    @Test
    public void shouldGetBlockById() {
        Block found = new Block();

        when(repo.findById(1L)).thenReturn(Optional.of(found));

        dao.getBlockById(1L);

        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void shouldFindBlocksWithFreeRooms() {
        when(repo.findBlockWithEmptyRooms()).thenReturn(List.of(new Block(), new Block()));

        dao.findBlocksWithFreeRooms();

        verify(repo, times(1)).findBlockWithEmptyRooms();
    }

}
