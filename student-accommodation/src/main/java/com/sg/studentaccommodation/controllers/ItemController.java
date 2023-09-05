package com.sg.studentaccommodation.controllers;

import com.sg.studentaccommodation.entities.Item;
import com.sg.studentaccommodation.services.dto.BulletinService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ItemController {
    private BulletinService bulletinService;
    private final int size = 6;
    @GetMapping(path = "/retrieve/bulletin/{id}")
    public Page<Item> retrieveBulletin(@PathVariable(name = "id") Long id,
                                       @RequestParam(required = false, defaultValue = "true") boolean isAcs,
                                       @RequestParam(required = false, defaultValue = "1") int page) {
        Pageable pageable = null;

        if (isAcs) {
            pageable = PageRequest.of(page, size, Sort.by("date").ascending());
        }
        else {
            pageable = PageRequest.of(page, size, Sort.by("date").descending());
        }

        return bulletinService.retrieveBulletin(pageable, id);
    }

    @PostMapping(path = "/put/item/{hostId}")
    public Item putItem(@RequestBody Item item, @PathVariable Long hostId) {

        return this.bulletinService.addItem(item, hostId);
    }
}
