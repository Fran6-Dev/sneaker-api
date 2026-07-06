package com.francis.sneaker_api.controller;

import com.francis.sneaker_api.dto.CreateScheduleRequest;
import com.francis.sneaker_api.dto.ScheduleResponse;
import com.francis.sneaker_api.model.WorkDay;
import com.francis.sneaker_api.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ScheduleResponse> createSchedule(@Valid @RequestBody CreateScheduleRequest request) {
        return ResponseEntity.ok(scheduleService.createSchedule(request));
    }

    @GetMapping
    public List<ScheduleResponse> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/day/{day}")
    public List<ScheduleResponse> getByDay(@PathVariable WorkDay day) {
        return scheduleService.getSchedulesByDay(day);
    }

    @GetMapping("/employee/{employeeName}")
    public List<ScheduleResponse> getByEmployee(@PathVariable String employeeName) {
        return scheduleService.getSchedulesByEmployee(employeeName);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}