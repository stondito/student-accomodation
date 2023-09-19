package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.HostDtoOut;
import com.sg.studentaccommodation.services.dto.HostServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
public final class HostController {
    private final HostServiceDto serviceDto;

    @PostMapping(path = "/host/register")
    public HostDtoOut registerHost(@RequestBody HostDtoIn hostDtoIn) throws ParseException {
        System.out.println(hostDtoIn);

        SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
        String strDate = sm.format(new Date());

        Date dt = sm.parse(strDate);
        hostDtoIn.setDataPfEntrance(dt);

        return this.serviceDto.registerHost(hostDtoIn);
    }

    @PostMapping(path = "/host/login")
    public HostDtoOut retrieveHost(@Validated @RequestBody HostDtoIn hostDtoIn) {
        System.out.println( "Hit " + hostDtoIn);

        return this.serviceDto.retrieveHost(hostDtoIn);
    }
}
