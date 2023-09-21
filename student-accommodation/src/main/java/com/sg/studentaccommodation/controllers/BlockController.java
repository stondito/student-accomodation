package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.ComplainDto;
import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.services.dto.BlockServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BlockController {
    private final BlockServiceDto service;

    @Transactional
    @PostMapping(path = "/block/add")
    public Block saveBlock(@RequestBody Block block) {
        return this.service.saveBlock(block);
    }

    @GetMapping(path = "/block/{id}/get/complains")
    public Page<ComplainDto> getComplains(@RequestParam(name = "size") String size,
                                          @RequestParam(name = "page") String page,
                                          @PathVariable(name = "id") Long id) {

        return this.service.findComplainsByBlockId(id, PageRequest.of(Integer.parseInt(page.trim()), Integer.parseInt(size.trim())));
    }
}
