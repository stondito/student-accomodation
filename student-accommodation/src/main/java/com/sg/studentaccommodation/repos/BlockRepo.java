package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepo extends JpaRepository<Block, Long> {
    @Query(value = """
        select tb.*
        from td_block tb
        join room r on tb.id = r.block_id
        left join student s on r.id = s.room_id
        where r.number_of_beds > (select count(*) from student s1 where s1.room_id = r.id)
        group by tb.id;
                                  
        """,
            nativeQuery = true)
    List<Block> findBlockWithEmptyRooms();
}

