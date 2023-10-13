package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Complain;
import com.sg.studentaccommodation.services.dao.ComplainDao;
import com.sg.studentaccommodation.services.dto.impl.ComplainServiceDtoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ComplainServiceDtoTest {

    @Mock
    private ModelMapper mapper;

    @Mock
    private ComplainDao dao;

    @InjectMocks
    private ComplainServiceDtoImpl service;


    @Test
    public void testSaveComplain() {
        Complain complain = new Complain();
        ComplainDto dto = new ComplainDto();

        when(dao.saveComplain(complain)).thenReturn(complain);
        when(mapper.map(complain, ComplainDto.class)).thenReturn(dto);

        service.saveComplain(complain);

        verify(dao, times(1)).saveComplain(complain);
        verify(mapper, times(1)).map(complain, ComplainDto.class);
    }

    @Test
    public void testFindComplainsByBlockId() {
        Complain complain = new Complain();
        ComplainDto dto = new ComplainDto();

        when(dao.findComplainsByBlockId(1L, PageRequest.of(0,2)))
                .thenReturn(new PageImpl<>(List.of(complain)));
        when(mapper.map(complain, ComplainDto.class)).thenReturn(dto);

        service.findComplainsByBlockId(1L, PageRequest.of(0,2));

        verify(dao, times(1)).findComplainsByBlockId(1L, PageRequest.of(0,2));
        verify(mapper, times(1)).map(complain, ComplainDto.class);
    }
}
