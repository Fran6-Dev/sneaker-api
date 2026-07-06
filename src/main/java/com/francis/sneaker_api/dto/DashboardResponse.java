package com.francis.sneaker_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {
    private Double totalRevenue;
    private Double totalExpenses;
    private Double profit;
    private Long totalSales;
    private Long totalProducts;
}
