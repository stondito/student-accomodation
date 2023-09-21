package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.services.dao.BlockDao;
import com.sg.studentaccommodation.services.dto.BlockServiceDto;
import com.sg.studentaccommodation.services.dto.RoomServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlockServiceDtoImpl implements BlockServiceDto{
    private final BlockDao dao;
    private final RoomServiceDto roomServiceDto;
    @Override
    public Block saveBlock(Block block) {
        Block saved = dao.saveBlock(block);
        saved.getRooms().forEach(r-> {
            r.setBlock(block);
            roomServiceDto.saveRoom(r);
        });

        return saved;
    }
}
