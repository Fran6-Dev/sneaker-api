package com.francis.sneaker_api.dto;

import com.francis.sneaker_api.model.WorkDay;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Data
public class CreateScheduleRequest {

    @NotBlank(message = "Le nom de l'employé est obligatoire")
    private String employeeName;

    @NotNull(message = "Le jour est obligatoire")
    private WorkDay day;

    @NotNull(message = "L'heure de début est obligatoire")
    private LocalTime startTime;

    @NotNull(message = "L'heure de fin obligatoire")
    private LocalTime endTime;

    private String note;
}
