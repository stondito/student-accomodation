package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.repos.BlockRepo;
import com.sg.studentaccommodation.services.dao.BlockDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class BlockDaoImpl implements BlockDao {

    private final BlockRepo blockDao;
}
