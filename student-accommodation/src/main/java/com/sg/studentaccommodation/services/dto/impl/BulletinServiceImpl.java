package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.entities.Item;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.services.dao.HostDao;
import com.sg.studentaccommodation.services.dao.ItemDao;
import com.sg.studentaccommodation.services.dto.BulletinService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BulletinServiceImpl implements BulletinService {

    private ItemDao itemDao;
    private HostDao hostDao;
    @Override
    public Page<Item> retrieveBulletin(Pageable pageable, Long id) {
        if (!hostDao.checkIfExistById(id)) {
            // todo custom exception
            throw new IllegalArgumentException();
        }

        return this.itemDao.getAllOrderByDate(pageable, id);
    }

    @Transactional
    @Override
    public Item addItem(Item item, Long hostId) {
        Host host = this.hostDao.getHostById(hostId);

        item.setHost(host);
        host.addItem(item);

        return this.itemDao.saveItem(item);
    }

}
