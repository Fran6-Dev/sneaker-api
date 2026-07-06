package com.francis.sneaker_api.dto;

import com.francis.sneaker_api.model.WorkDay;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ScheduleResponse {
    private Long id;
    private String employeeName;
    private WorkDay day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String note;
}
