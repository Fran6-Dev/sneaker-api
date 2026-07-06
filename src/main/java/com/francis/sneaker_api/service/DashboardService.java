package com.francis.sneaker_api.service;

import com.francis.sneaker_api.dto.DashboardResponse;
import com.francis.sneaker_api.repository.ExpenseRepository;
import com.francis.sneaker_api.repository.ProductRepository;
import com.francis.sneaker_api.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final SaleRepository saleRepository;
    private final ExpenseRepository expenseRepository;
    private final ProductRepository productRepository;

    public DashboardResponse getDashboard() {
    Double totalRevenue = saleRepository.findAll()
            .stream()
            .mapToDouble(sale -> sale.getTotalPrice())
            .sum();

    Double totalExpenses = expenseRepository.findAll()
            .stream()
            .mapToDouble(expense -> expense.getAmount())
            .sum();

    Double profit = totalRevenue - totalExpenses;
    Long totalSales = saleRepository.count();
    Long totalProducts = productRepository.count();

    return new DashboardResponse(
            totalRevenue,
            totalExpenses,
            profit,
            totalSales,
            totalProducts
    );
    }
}
