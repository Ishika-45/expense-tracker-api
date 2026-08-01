package com.ishika.expensetracker.service;

import com.ishika.expensetracker.dto.CreateExpenseRequest;
import com.ishika.expensetracker.model.Expense;
import com.ishika.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense addExpense(CreateExpenseRequest request) {

        Expense expense = new Expense(
                UUID.randomUUID(),
                request.getTitle(),
                request.getAmount(),
                request.getCategory(),
                request.getDate()
        );

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

    public BigDecimal getTotalExpenses() {

        BigDecimal total = BigDecimal.ZERO;

        for (Expense expense : expenseRepository.findAll()) {
            total = total.add(expense.getAmount());
        }

        return total;
    }

    public BigDecimal getTotalExpensesByCategory(String category) {

        BigDecimal total = BigDecimal.ZERO;

        for (Expense expense : expenseRepository.findByCategory(category)) {
            total = total.add(expense.getAmount());
        }

        return total;
    }

    public boolean deleteExpense(UUID id) {
        return expenseRepository.deleteById(id);
    }
}