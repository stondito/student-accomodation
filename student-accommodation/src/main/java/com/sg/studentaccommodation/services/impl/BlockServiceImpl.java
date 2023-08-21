package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.BlockDao;
import com.sg.studentaccommodation.services.BlockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BlockServiceImpl implements BlockService {

    private final BlockDao blockDao;
}
