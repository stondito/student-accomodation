package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {

    @Query(value =
            """
            select r.*
            from room r
            left join student s on r.id = s.room_id
            where r.block_id = :blockId
            and r.number_of_beds > (select count(*) from student s1 where s1.room_id = r.id);
            """
            , nativeQuery = true)
    List<Room> findFreeRooms(@Param("blockId") Long blockId);
}
