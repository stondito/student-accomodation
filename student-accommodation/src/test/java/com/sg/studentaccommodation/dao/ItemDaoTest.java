package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.Item;
import com.sg.studentaccommodation.repos.ItemRepository;
import com.sg.studentaccommodation.services.dao.impl.ItemDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ItemDaoTest {

    @Mock
    private ItemRepository repo;

    @InjectMocks
    private ItemDaoImpl dao;

    @Test
    public void shouldGetAllOrderByDate() {
        dao.getAllOrderByDate(PageRequest.of(0, 2), 1L);

        verify(repo, times(1)).findAllByHostIdOrderByDate(PageRequest.of(0,2), 1L);
    }
    @Test
    public void shouldSaveItem() {
        Item item = new Item();

        dao.saveItem(item);

        verify(repo, times(1)).save(item);
    }

}
