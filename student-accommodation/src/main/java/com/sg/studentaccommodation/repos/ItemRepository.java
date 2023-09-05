package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findAllByHostIdOrderByDate(Pageable pageable, Long hostId);
}
