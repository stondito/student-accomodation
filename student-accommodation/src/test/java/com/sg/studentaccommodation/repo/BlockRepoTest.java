package com.sg.studentaccommodation.repo;

import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.repos.BlockRepo;
import com.sg.studentaccommodation.repos.RoomRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlockRepoTest {
    private Long blockId;
    @Autowired
    private BlockRepo repo;

    @Autowired
    private RoomRepo roomRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void shouldSave() {
        List<Room> rooms = List.of(new Room(), new Room());
        Block block = new Block();
        block.setNumber(1);
        block.setRooms(rooms);
        rooms.forEach((r) -> r.setBlock(block));

        Block saved = repo.saveAndFlush(block);
        roomRepo.save(block.getRooms().get(0));
        roomRepo.save(block.getRooms().get(1));

        assertNotNull(saved);
        assertEquals(block, saved);
        assertEquals(2, saved.getRooms().size());

        blockId = saved.getId();
        repo.deleteById(blockId);

        List<Block> list = repo.findBlockWithEmptyRooms();

        assertTrue(list.isEmpty());

        assertThrows(Exception.class, () -> repo.findById(blockId).orElseThrow(Exception::new));
    }

}
