package com.sg.studentaccommodation.dao;

import com.sg.studentaccommodation.dto.StudentDtoIn;
import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.entities.people.Student;
import com.sg.studentaccommodation.repos.StudentRepo;
import com.sg.studentaccommodation.services.dao.impl.StudentDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentDaoTest {
    @Mock
    private StudentRepo repo;

    @Mock
    private ModelMapper mapper;

    @Mock
    private Student studentMock;
    @InjectMocks
    private StudentDaoImpl dao;

    @Test
    public void shouldRetrieveUser(){
        StudentDtoIn studentDtoIn = new StudentDtoIn();
        studentDtoIn.setFn(1);
        studentDtoIn.setPassword("password");

        Student student = new Student();

        when(repo.findStudentByFnAndPassword(studentDtoIn.getFn(), studentDtoIn.getPassword()))
                .thenReturn(Optional.of(student));

        dao.retrieveUser(studentDtoIn);

        verify(repo, times(1))
                .findStudentByFnAndPassword(studentDtoIn.getFn(), studentDtoIn.getPassword());
    }
    @Test
    public void shouldRegisterUser(){
        StudentDtoIn studentDtoIn = new StudentDtoIn();
        studentDtoIn.setFn(1);
        studentDtoIn.setPassword("password");

        Student student = new Student();

        when(mapper.map(studentDtoIn, Student.class)).thenReturn(studentMock);
        when(repo.save(studentMock)).thenReturn(studentMock);

        dao.registerUser(studentDtoIn);

        verify(mapper, times(1)).map(studentDtoIn, Student.class);
        verify(studentMock, times(1)).setStatus(Status.New);
        verify(repo, times(1)).save(studentMock);
    }
    @Test
    public void shouldGetById() {
        Student student = new Student();
        when(repo.findById(1L)).thenReturn(Optional.of(student));

        dao.getById(1L);

        verify(repo, times(1)).findById(1L);
    }
    @Test
    public void shouldFindNwwStatusStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student());

        Page<Student> studentPage = new PageImpl<>(studentList);
        when(repo.findStudentsByStatus(Status.Waiting, PageRequest.of(0, 2)))
                .thenReturn(studentPage);

        dao.findNEwStatusStudents( PageRequest.of(0, 2));

        verify(repo, times(1))
                .findStudentsByStatus(Status.Waiting, PageRequest.of(0, 2));
    }

    @Test
    public void shouldGetAll() {
        dao.getAll();

        verify(repo, times(1)).findAll();
    }

}
