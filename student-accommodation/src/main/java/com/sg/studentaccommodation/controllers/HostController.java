package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;
import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.services.dto.HostServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
public class HostController {
    private final HostServiceDto serviceDto;

    @PostMapping(path = "/host/register")
    public HostDtoOut registerHost(@RequestBody HostDtoIn hostDtoIn) throws ParseException {
        System.out.println(hostDtoIn);

        SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sm.format(new Date());

        Date dt = sm.parse(strDate);
        hostDtoIn.setDateOfEntrance(dt);

        HostDtoOut dto = this.serviceDto.registerHost(hostDtoIn);
        System.out.println(dto.getId() + " " + dto.getDateOfEntrance());
        return dto;
    }

    @PostMapping(path = "/host/login")
    public HostDtoOut retrieveHost(@Validated @RequestBody HostDtoIn hostDtoIn) {
        System.out.println( "Hit " + hostDtoIn);

        return this.serviceDto.retrieveHost(hostDtoIn);
    }

    @Transactional
    @GetMapping(path = "/host/get/{id}")
    public HostDtoOut getHost(@PathVariable(name = "id") Long id) {
        return this.serviceDto.getHostById(id);
    }

    @GetMapping(path = "/host/{id}/block")
    public Long getBlockIdBySHostId(@PathVariable(name = "id") Long id) {
        return this.serviceDto.getBlockByHostId(id);
    }

    @Transactional
    @PutMapping(path = "/host/{id}/appoint/{blockID}")
    public HostDtoOut appoint(@PathVariable(name = "id") Long id, @PathVariable(name = "blockID") Long blockId) {
        return this.serviceDto.appoint(id, blockId);
    }
}
