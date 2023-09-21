package com.sg.studentaccommodation.services.dao;

import com.sg.studentaccommodation.entities.Complain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ComplainDao {
    Complain saveComplain(Complain complain);

    Page<Complain> findComplainsByBlockId(Long blockId, Pageable pageable);
}
