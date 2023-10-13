package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.services.dao.BlockDao;
import com.sg.studentaccommodation.services.dto.ComplainServiceDto;
import com.sg.studentaccommodation.services.dto.RoomServiceDto;
import com.sg.studentaccommodation.services.dto.impl.BlockServiceDtoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlockServiceDtoTest {
    @Mock
    private BlockDao dao;

    @Mock
    private RoomServiceDto roomServiceDto;

    @Mock
    private ComplainServiceDto complainServiceDto;

    @InjectMocks
    private BlockServiceDtoImpl service;

    @Test
    public void testSaveBlock() {
        Block block = new Block();
        block.setId(1L);

        Room room = new Room();
        block.setRooms(List.of(room));

        when(dao.saveBlock(block)).thenReturn(block);

        Block returned = service.saveBlock(block);

        verify(dao, times(1)).saveBlock(block);
        verify(roomServiceDto, times(1)).saveRoom(room);

        assertEquals(block, returned);

    }


    @Test
    public void testFindComplainsByBlockId() {
        service.findComplainsByBlockId(1L, PageRequest.of(0,2));

        verify(complainServiceDto, times(1))
                .findComplainsByBlockId(1L, PageRequest.of(0,2));
    }

    @Test
    public void testHetBlockById() {
        service.getBlockByID(1L);

        verify(dao, times(1)).getBlockById(1L);
    }

    @Test
    public void testFindBlocksWithFreeRooms() {
        service.findBlocksWithFreeRooms();

        verify(dao, times(1)).findBlocksWithFreeRooms();
    }
}
