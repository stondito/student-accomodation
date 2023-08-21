package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.services.BlockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BlockController {
    private final BlockService blockService;
}
