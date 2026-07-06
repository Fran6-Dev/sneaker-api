package com.francis.sneaker_api.service;

import com.francis.sneaker_api.dto.CreateExpenseRequest;
import com.francis.sneaker_api.dto.ExpenseResponse;
import com.francis.sneaker_api.model.Expense;
import com.francis.sneaker_api.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

     private final ExpenseRepository expenseRepository;

     private ExpenseResponse toResponse(Expense expense) {
         return new ExpenseResponse(
                 expense.getId(),
                 expense.getDescription(),
                 expense.getAmount(),
                 expense.getCategory(),
                 expense.getExpenseDate()
         );
     }

     public ExpenseResponse createExpense (CreateExpenseRequest request) {
         Expense expense = new Expense();
         expense.setDescription(request.getDescription());
         expense.setAmount(request.getAmount());
         expense.setCategory(request.getCategory());
         return toResponse(expenseRepository.save(expense));
     }

     public List<ExpenseResponse> getAllExpenses() {
         return expenseRepository.findAllByOrderByExpenseDateDesc()
                 .stream()
                 .map(this::toResponse)
                 .toList();
     }

     public void deleteExpense(Long id) {
         expenseRepository.deleteById(id);
     }
}
