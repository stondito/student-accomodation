package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.dto.ComplainDto;
import com.sg.studentaccommodation.entities.Complain;
import com.sg.studentaccommodation.services.dao.ComplainDao;
import com.sg.studentaccommodation.services.dto.ComplainServiceDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<ComplainDto> findComplainsByBlockId(Long blockId, Pageable pageable) {
        return this.dao.
                findComplainsByBlockId(blockId, pageable).
                map(c-> this.mapper.map(c, ComplainDto.class));
    }
}
