package com.francis.sneaker_api.dto;

import com.francis.sneaker_api.model.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExpenseResponse {
    private Long id;
    private String description;
    private Double amount;
    private ExpenseCategory category;
    private LocalDateTime expenseDate;
}
