package com.sg.studentaccommodation.services.impl;

import com.sg.studentaccommodation.dao.RoomDao;
import com.sg.studentaccommodation.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;

}
