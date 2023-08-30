package com.sg.studentaccommodation.repos;

import com.sg.studentaccommodation.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepo extends JpaRepository<Block, Long> {
}
