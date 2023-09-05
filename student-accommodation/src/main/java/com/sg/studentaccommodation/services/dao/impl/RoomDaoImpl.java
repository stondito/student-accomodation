package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.repos.RoomRepo;
import com.sg.studentaccommodation.services.dao.RoomDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class RoomDaoImpl implements RoomDao {
    private final RoomRepo roomDao;

}
