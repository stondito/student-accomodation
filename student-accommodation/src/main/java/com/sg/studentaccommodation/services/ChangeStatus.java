package com.sg.studentaccommodation.services;

import com.sg.studentaccommodation.entities.objects.Status;
import com.sg.studentaccommodation.services.dao.impl.StudentDaoImpl;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ChangeStatus {
    private final StudentDaoImpl studentDao;

    // todo once a year
    @Transactional
    @Scheduled(cron = "0 0 22 * * ?")// sec(0-59) min(0-59) h(0-23) day month day of the week everything is
    public void changeStatusStudent() {
        System.out.println("Scheduling...");
        studentDao.getAll().stream()
                .peek(s->s.setYearOfStudying(s.getYearOfStudying()+1))
                .filter(s-> s.getYearOfStudying() > 3)
                .peek(s->s.setStatus(Status.Expiring))
                .filter(s-> s.getYearOfStudying() == 4)
                .forEach(s-> s.setStatus(Status.Left));
    }
}
