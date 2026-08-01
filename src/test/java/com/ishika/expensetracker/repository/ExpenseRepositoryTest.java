package com.ishika.expensetracker.repository;

import com.ishika.expensetracker.model.Expense;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseRepositoryTest {

    @Test
    void shouldSaveExpense() {

        // Arrange
        ExpenseRepository repository = new ExpenseRepository();

        Expense expense = new Expense(
                UUID.randomUUID(),
                "Pizza",
                BigDecimal.valueOf(350),
                "Food",
                LocalDate.now());

        // Act
        repository.save(expense);

        // Assert
        List<Expense> expenses = repository.findAll();

        assertEquals(1, expenses.size());
        assertEquals("Pizza", expenses.get(0).getTitle());
    }

    @Test
    void shouldFindExpensesByCategory() {

        // Arrange
        ExpenseRepository repository = new ExpenseRepository();

        Expense pizza = new Expense(
                UUID.randomUUID(),
                "Pizza",
                BigDecimal.valueOf(350),
                "Food",
                LocalDate.now());

        Expense burger = new Expense(
                UUID.randomUUID(),
                "Burger",
                BigDecimal.valueOf(200),
                "Food",
                LocalDate.now());

        Expense uber = new Expense(
                UUID.randomUUID(),
                "Uber",
                BigDecimal.valueOf(500),
                "Travel",
                LocalDate.now());

        repository.save(pizza);
        repository.save(burger);
        repository.save(uber);

        // Act
        List<Expense> foodExpenses = repository.findByCategory("Food");

        // Assert
        assertEquals(2, foodExpenses.size());
        assertEquals("Pizza", foodExpenses.get(0).getTitle());
        assertEquals("Burger", foodExpenses.get(1).getTitle());
        assertEquals("Food", foodExpenses.get(0).getCategory());
        assertEquals("Food", foodExpenses.get(1).getCategory());
    }

    @Test
    void shouldDeleteExpenseById() {
        // Arrange
        ExpenseRepository repository = new ExpenseRepository();

        Expense pizza = new Expense(
                UUID.randomUUID(),
                "Pizza",
                BigDecimal.valueOf(350),
                "Food",
                LocalDate.now());

        Expense burger = new Expense(
                UUID.randomUUID(),
                "Burger",
                BigDecimal.valueOf(200),
                "Food",
                LocalDate.now());

        Expense uber = new Expense(
                UUID.randomUUID(),
                "Uber",
                BigDecimal.valueOf(500),
                "Travel",
                LocalDate.now());

        repository.save(pizza);
        repository.save(burger);
        repository.save(uber);

        // Act
        boolean deleted = repository.deleteById(burger.getId());

        // Assert
        assertTrue(deleted);

        List<Expense> expenses = repository.findAll();

        assertEquals(2, expenses.size());
        assertTrue(
    expenses.stream()
            .noneMatch(expense -> expense.getId().equals(burger.getId()))
);
    }
}