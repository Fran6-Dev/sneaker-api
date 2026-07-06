package com.francis.sneaker_api.dto;

import com.francis.sneaker_api.model.ExpenseCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateExpenseRequest {

    @NotBlank(message = "La description est obligatoire")
    private String description;

    @NotNull(message = "Le montant est obligatoire")
    @Min(value = 0, message = "Le montant doit être positif")
    private Double amount;

    @NotNull(message = "La catégorie est obligatoire")
    private ExpenseCategory category;
}
