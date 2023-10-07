package com.sg.studentaccommodation.services.dao.impl;

import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.repos.StudentRepo;

import com.sg.studentaccommodation.services.dao.StudentDao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public final class StudentDaoImpl implements StudentDao {
    private final StudentRepo studentRepo;
    private ModelMapper modelMapper;

    @Override
    public Student retrieveUser(StudentDtoIn student) {

        return this.studentRepo.findStudentByFnAndPassword(student.getFn(), student.getPassword())
                .orElseThrow(() -> new RuntimeException("Can't find user"));
    }

    @Override
    public Student registerUser(StudentDtoIn student) {
        Student s = modelMapper.map(student, Student.class);
        s.setStatus(Status.New);

        return this.studentRepo.save(s);
    }

    @Override
    public Student getById(Long id) {
        return this.studentRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find user with id: " + id));
    }

    @Override
    public Page<Student> findNEwStatusStudents(Pageable pageable) {
        return this.studentRepo.findStudentsByStatus(Status.Waiting, pageable);
    }

    public List<Student> getAll() {
        return this.studentRepo.findAll();
    }
}
