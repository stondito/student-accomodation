package com.sg.studentaccommodation.dto;

import com.sg.studentaccommodation.entities.Item;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.repos.RoomRepo;
import com.sg.studentaccommodation.services.dao.HostDao;
import com.sg.studentaccommodation.services.dao.ItemDao;
import com.sg.studentaccommodation.services.dao.StudentDao;
import com.sg.studentaccommodation.services.dto.impl.BulletinServiceImpl;
import com.sg.studentaccommodation.services.dto.impl.RoomServiceDtoImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BulletinServiceDtoTest {
    @Mock
    private ItemDao itemDao;

    @Mock
    private HostDao hostDao;

    @InjectMocks
    private BulletinServiceImpl service;

    @Test
    public void testRetrieveBulletin() {
        when(hostDao.checkIfExistById(1L)).thenReturn(true);

        service.retrieveBulletin(PageRequest.of(0,2), 1L);

        verify(itemDao, times(1))
                .getAllOrderByDate(PageRequest.of(0,2), 1L);
    }

    // todo make custom exception
    @Test
    @Disabled
    public void testFailRetrieveBulletin() {
        when(hostDao.checkIfExistById(1L)).thenReturn(false);

        assertThrows(IllegalAccessError.class, () -> service
                .retrieveBulletin(PageRequest.of(0,2), 1L));

    }

    @Test
    public void shouldAddItem() {
        Host saved = new Host();
        saved.setId(1L);

        Item item = new Item();
        item.setId(2L);

        when(hostDao.getHostById(saved.getId())).thenReturn(saved);
        when(itemDao.saveItem(item)).thenReturn(item);

        Item found = service.addItem(item, saved.getId());

        verify(hostDao, times(1)).getHostById(saved.getId());

        assertNotNull(found);
        assertEquals(item, found);
    }

}
