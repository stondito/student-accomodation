package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.objects.Sex;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.repos.RoomRepo;
import com.sg.studentaccommodation.services.dao.RoomDao;
import com.sg.studentaccommodation.services.dao.StudentDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public final class RoomDaoImpl implements RoomDao {
    private final RoomRepo roomRepo;
    private final StudentDao studentDao;
    @Override
    public Room getRoom(Long id) {
        return this.roomRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid room id"));
    }

    @Override
    public Room addStudentInRoom(StudentDtoIn studentDtoIn, Room room) {
        Student student = studentDao.retrieveUser(studentDtoIn);
        student.setStatus(Status.Accommodated);
        student.setRoom(room);

        room.addStudent(student);

        return room;
    }

    @Override
    public Room saveRoom(Room room) {
        return this.roomRepo.save(room);
    }

    @Override
    public List<Room> findFreeRooms(Long blockId) {
        return this.roomRepo.findFreeRooms(blockId);
    }
}
