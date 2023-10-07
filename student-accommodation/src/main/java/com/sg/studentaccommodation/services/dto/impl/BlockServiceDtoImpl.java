package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.dto.ComplainDto;
import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.services.dao.BlockDao;
import com.sg.studentaccommodation.services.dto.BlockServiceDto;
import com.sg.studentaccommodation.services.dto.ComplainServiceDto;
import com.sg.studentaccommodation.services.dto.RoomServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlockServiceDtoImpl implements BlockServiceDto{
    private final BlockDao dao;
    private final RoomServiceDto roomServiceDto;
    private final ComplainServiceDto complainServiceDto;
    @Override
    public Block saveBlock(Block block) {
        Block saved = dao.saveBlock(block);
        saved.getRooms().forEach(r-> {
            r.setBlock(block);
            roomServiceDto.saveRoom(r);
        });

        return saved;
    }

    @Override
    public Page<ComplainDto> findComplainsByBlockId(Long blockId, Pageable pageable) {

        return this.complainServiceDto.findComplainsByBlockId(blockId, pageable);
    }

    @Override
    public Block getBlockByID(Long id) {
        return this.dao.getBlockById(id);
    }

    @Override
    public List<Block> findBlocksWithFreeRooms() {
        return this.dao.findBlocksWithFreeRooms();
    }
}
