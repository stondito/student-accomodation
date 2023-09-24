package com.sg.studentaccommodation.services.dto;


import com.sg.studentaccommodation.dto.ComplainDto;
import com.sg.studentaccommodation.entities.Block;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlockServiceDto {
    Block saveBlock(Block block);

    Page<ComplainDto> findComplainsByBlockId(Long blockID, Pageable pageable);

    Block getBlockByID(Long id);
}
