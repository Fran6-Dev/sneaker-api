package com.francis.sneaker_api.dto;

import com.francis.sneaker_api.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Integer stock;
    private String description;
    private Category category;
}
