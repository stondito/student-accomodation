package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.Complain;
import com.sg.studentaccommodation.repos.ComplainRepo;
import com.sg.studentaccommodation.services.dao.impl.ComplainDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ComplainDaoTest {

    @Mock
    private ComplainRepo repo;

    @InjectMocks
    private ComplainDaoImpl dao;

    @Test
    public void shouldSaveComplain(){
        Complain complain = new Complain();

        dao.saveComplain(complain);

        verify(repo, times(1)).save(complain);
    }
    @Test
    public void shouldFindComplainsByBlockId() {
        dao.findComplainsByBlockId(1L, PageRequest.of(0, 2));

        verify(repo, times(1))
                .findComplainsByBlockId(1L, PageRequest.of(0, 2));
    }

}
