package com.sg.studentaccommodation.services.dao;

import com.sg.studentaccommodation.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemDao {
    Page<Item> getAllOrderByDate(Pageable pageable, Long hostId);

    Item saveItem(Item item);
}
