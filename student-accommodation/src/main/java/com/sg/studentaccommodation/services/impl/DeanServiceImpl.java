package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.DeanDao;
import com.sg.studentaccommodation.services.DeanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeanServiceImpl implements DeanService {
    private final DeanDao deanDao;
}
