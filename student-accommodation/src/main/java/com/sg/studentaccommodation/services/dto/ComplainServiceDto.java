package com.sg.studentaccommodation.services.dto;

import com.sg.studentaccommodation.dto.ComplainDto;
import com.sg.studentaccommodation.entities.Complain;

public interface ComplainServiceDto {
    ComplainDto saveComplain(Complain complain);
}
