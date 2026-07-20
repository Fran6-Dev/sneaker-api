package com.francis.sneaker_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ScheduleResponse {
    private Long id;
    private String employeeName;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String note;
}