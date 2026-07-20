package com.francis.sneaker_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SaleResponse {
    private Long id;
    private String productName;
    private String productBrand;
    private Integer quantity;
    private String productSize;
    private Double promotion;
    private Double totalPrice;
    private LocalDateTime saleDate;
}
