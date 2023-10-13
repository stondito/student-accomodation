package com.sg.studentaccommodation;

import com.sg.studentaccommodation.entities.Item;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.repos.HostRepo;
import com.sg.studentaccommodation.services.dto.BulletinService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ItemAndHostTest {
    @Autowired
    private BulletinService bulletinService;

    @Autowired
    private HostRepo hostRepo;

    @Disabled
    @Test
    public void testAddItemInBulletin() {

        Host host = hostRepo.findById((long) 31).get();

        Item savedItem = bulletinService.addItem(new Item(), host.getId());

        assertNotNull(savedItem);
        assertEquals(host.getId(), savedItem.getHost().getId());
    }
}
