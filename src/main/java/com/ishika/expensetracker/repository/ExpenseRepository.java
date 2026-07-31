package com.ishika.expensetracker.repository;

import com.ishika.expensetracker.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ExpenseRepository {

    private final List<Expense> expenses = new ArrayList<>();

    public Expense save(Expense expense) {
        expenses.add(expense);
        return expense;
    }

    public List<Expense> findAll() {
        return expenses;
    }

    public List<Expense> findByCategory(String category) {
        List<Expense> result = new ArrayList<>();

        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                result.add(expense);
            }
        }

        return result;
    }

    public boolean deleteById(UUID id) {
        return expenses.removeIf(expense -> expense.getId().equals(id));
    }
}