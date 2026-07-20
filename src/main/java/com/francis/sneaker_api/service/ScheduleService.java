package com.francis.sneaker_api.service;

import com.francis.sneaker_api.dto.CreateScheduleRequest;
import com.francis.sneaker_api.dto.ScheduleResponse;
import com.francis.sneaker_api.model.Schedule;
import com.francis.sneaker_api.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private ScheduleResponse toResponse(Schedule schedule) {
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getEmployeeName(),
                schedule.getDate(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getNote()
        );
    }

    private Schedule toEntity(CreateScheduleRequest request) {
        Schedule schedule = new Schedule();
        schedule.setEmployeeName(request.getEmployeeName());
        schedule.setDate(request.getDate());
        schedule.setStartTime(request.getStartTime());
        schedule.setEndTime(request.getEndTime());
        schedule.setNote(request.getNote());
        return schedule;
    }

    public ScheduleResponse createSchedule(CreateScheduleRequest request) {
        return toResponse(scheduleRepository.save(toEntity(request)));
    }

    public List<ScheduleResponse> getAllSchedules() {
        return scheduleRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}