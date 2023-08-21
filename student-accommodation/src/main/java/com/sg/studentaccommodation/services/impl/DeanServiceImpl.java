package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.DeanDao;
import com.sg.studentaccommodation.services.DeanService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeanServiceImpl implements DeanService {
    private final DeanDao deanDao;
}
