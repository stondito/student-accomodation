package com.sg.studentaccommodation.services.dto;

import com.sg.studentaccommodation.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BulletinService {
    Page<Item> retrieveBulletin(Pageable pageable, Long id);

    Item addItem(Item item, Long hostId);
}
