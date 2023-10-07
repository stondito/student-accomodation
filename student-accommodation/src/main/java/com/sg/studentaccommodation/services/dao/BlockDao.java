package com.sg.studentaccommodation.services.dao;

import com.sg.studentaccommodation.entities.Block;

import java.util.List;

public interface BlockDao {

    Block saveBlock(Block block);

    Block getBlockById(Long id);

    List<Block> findBlocksWithFreeRooms();
}
