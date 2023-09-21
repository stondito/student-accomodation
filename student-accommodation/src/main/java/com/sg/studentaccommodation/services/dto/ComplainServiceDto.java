package com.sg.studentaccommodation.services.dto;

import com.sg.studentaccommodation.dto.ComplainDto;
import com.sg.studentaccommodation.entities.Complain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ComplainServiceDto {
    ComplainDto saveComplain(Complain complain);

    Page<ComplainDto> findComplainsByBlockId(Long block, Pageable pageable);
}
