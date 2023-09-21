package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.services.dto.BlockServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BlockController {
    private final BlockServiceDto service;

    @Transactional
    @PostMapping(path = "/block/add")
    public Block saveBlock(@RequestBody Block block) {
        return this.service.saveBlock(block);
    }
}
