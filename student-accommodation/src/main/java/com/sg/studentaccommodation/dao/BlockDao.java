package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockDao extends JpaRepository<Block, Long> {
}
