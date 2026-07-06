package com.francis.sneaker_api.dto;

import com.francis.sneaker_api.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class CreateProductRequest {
    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @NotBlank(message = "La marque est obligatoire")
    private String brand;

    @NotNull(message = "Le prix est obligatoir ")
    private Double price;

    @NotNull(message = "Le stock est obligatoire")
    @Min(value = 0, message = "Le stock doit être positif")
    private Integer stock;

    private String description;

    @NotNull(message = "La catégorie est obligatoire")
    private Category category;
}
