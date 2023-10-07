package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.repos.BlockRepo;
import com.sg.studentaccommodation.services.dao.BlockDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public final class BlockDaoImpl implements BlockDao {

    private final BlockRepo blockRepo;

    @Override
    public Block saveBlock(Block block) {
        return this.blockRepo.save(block);
    }

    @Override
    public Block getBlockById(Long id) {
        return this.blockRepo.findById(id).orElseThrow(()-> new RuntimeException("Block id not found " + id));
    }

    @Override
    public List<Block> findBlocksWithFreeRooms() {
        return this.blockRepo.findBlockWithEmptyRooms();
    }
}
