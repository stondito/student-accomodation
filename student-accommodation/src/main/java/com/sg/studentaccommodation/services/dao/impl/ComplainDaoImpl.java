package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.entities.Complain;
import com.sg.studentaccommodation.repos.ComplainRepo;
import com.sg.studentaccommodation.services.dao.ComplainDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComplainDaoImpl implements ComplainDao {
    private final ComplainRepo repo;
    @Override
    public Complain saveComplain(Complain complain) {
        return this.repo.save(complain);
    }
}
