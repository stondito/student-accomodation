package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.dto.ComplainDto;
import com.sg.studentaccommodation.entities.Complain;
import com.sg.studentaccommodation.services.dao.ComplainDao;
import com.sg.studentaccommodation.services.dto.ComplainServiceDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComplainServiceDtoImpl implements ComplainServiceDto {
    private final ModelMapper mapper;
    private final ComplainDao dao;


    @Override
    public ComplainDto saveComplain(Complain complain) {
        Complain saved = this.dao.saveComplain(complain);

        ComplainDto complainDto = this.mapper.map(saved, ComplainDto.class);

        return complainDto;
    }
}
