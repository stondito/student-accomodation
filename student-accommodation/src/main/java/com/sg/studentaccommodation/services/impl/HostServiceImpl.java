package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.HostDao;
import com.sg.studentaccommodation.services.HostService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HostServiceImpl implements HostService {
    private final HostDao hostDao;
}
