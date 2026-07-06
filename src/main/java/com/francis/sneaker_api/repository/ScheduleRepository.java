package com.francis.sneaker_api.repository;

import com.francis.sneaker_api.model.WorkDay;
import com.francis.sneaker_api.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByDay(WorkDay day);
    List<Schedule> findByEmployeeName(String employeeName);
}
