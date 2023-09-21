package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.Complain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepo extends JpaRepository<Complain, Long> {
    Page<Complain> findComplainsByBlockId(Long blockId, Pageable pageable);
}
