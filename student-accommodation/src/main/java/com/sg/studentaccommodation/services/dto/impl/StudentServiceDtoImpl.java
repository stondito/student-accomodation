package com.sg.studentaccommodation.services.dto.impl;

import com.sg.studentaccommodation.dto.HostDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.dto.StudentDtoOut;
import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.Complain;
import com.sg.studentaccommodation.entities.Room;
import com.sg.studentaccommodation.entities.people.Host;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.services.dao.HostDao;
import com.sg.studentaccommodation.services.dao.StudentDao;
import com.sg.studentaccommodation.services.dto.ComplainServiceDto;
import com.sg.studentaccommodation.services.dto.StudentServiceDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceDtoImpl implements StudentServiceDto {
    private final StudentDao dao;
    private final ModelMapper mapper;
    private final HostDao hostDao;
    private final ComplainServiceDto complainServiceDto;

    @Override
    public StudentDtoOut retrieveUser(StudentDtoIn student) {
        Student retrieved = this.dao.retrieveUser(student);

        StudentDtoOut studentDtoOut = this.mapper.map(retrieved, StudentDtoOut.class);

        return studentDtoOut;
    }

    @Override
    public StudentDtoOut registerUser(StudentDtoIn student) {
        Student saved = this.dao.registerUser(student);

        StudentDtoOut studentDtoOut = mapper.map(saved, StudentDtoOut.class);

        return studentDtoOut;
    }

    @Override
    public StudentDtoOut addHost(HostDtoIn hostDtoIn, Long studentId) {
        Student updating = this.dao.getById(studentId);

        Host host = this.hostDao.registerHost(hostDtoIn);

        updating.setHost(host);

        StudentDtoOut updated = mapper.map(updating, StudentDtoOut.class);

        return updated;
    }

    @Override
    public StudentDtoOut getStudent(Long id) {
        Student student = this.dao.getById(id);

        StudentDtoOut studentDtoOut = this.mapper.map(student, StudentDtoOut.class);

        return studentDtoOut;
    }

    @Override
    public boolean makeComplain(int roomNumber, Long id, String reason) {
        Student student = dao.getById(id);

        Block block = student.getRoom().getBlock();

        Room room = block.getRooms()
                        .stream()
                        .filter(r-> r.getRoomNumber() == roomNumber)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("no broom number in block found"));

        room.getStudents().stream().forEach(s -> {
            Complain complain = new Complain();

            complain.setReason(reason);
            complain.setRoom(room);
            complain.setFrom(student);
            complain.setBlock(room.getBlock());

            complainServiceDto.saveComplain(complain);

        });

        return true;
    }
}
