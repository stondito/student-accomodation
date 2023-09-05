package com.sg.studentaccommodation;

import com.sg.studentaccommodation.entities.Item;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.repos.HostRepo;
import com.sg.studentaccommodation.services.dto.BulletinService;
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

    @Test
    public void testAddItemInBulletin() {
        Host host = new Host();
        host.setSex(Sex.Male);
        host.setUsername("Milcho");
        host.setPassword("1234567");
        host.setFirstName("Milcho");
        host.setLastName("Milchev");

        hostRepo.save(host);

        Item savedItem = bulletinService.addItem(new Item(), host.getId());

        assertNotNull(savedItem);
        assertEquals(host.getId(), savedItem.getHost().getId());
    }
}
