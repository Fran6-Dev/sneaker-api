package com.francis.sneaker_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;

    private LocalDateTime expenseDate;

    @PrePersist
    public void prePersist() {
        this.expenseDate = LocalDateTime.now();
    }
}
