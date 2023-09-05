package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.entities.Item;
import com.sg.studentaccommodation.repos.ItemRepository;
import com.sg.studentaccommodation.services.dao.ItemDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemDaoImpl implements ItemDao {
    private ItemRepository repo;

    public Page<Item> getAllOrderByDate(Pageable pageable, Long HostId) {
        return this.repo.findAllByHostIdOrderByDate(pageable, HostId);
    }

    @Override
    public Item saveItem(Item item) {
        return this.repo.save(item);
    }
}
