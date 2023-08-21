package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.RoomDao;
import com.sg.studentaccommodation.services.RoomService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;

}
