package com.ishika.expensetracker.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {

    @Test
    void shouldCreateExpenseUsingParameterizedConstructor() {

        // Arrange
        UUID id = UUID.randomUUID();
        LocalDate date = LocalDate.now();

        // Act
        Expense expense = new Expense(
                id,
                "Pizza",
                BigDecimal.valueOf(350),
                "Food",
                date
        );

        // Assert
        assertEquals(id, expense.getId());
        assertEquals("Pizza", expense.getTitle());
        assertEquals(BigDecimal.valueOf(350), expense.getAmount());
        assertEquals("Food", expense.getCategory());
        assertEquals(date, expense.getDate());
    }

    @Test
    void shouldCreateExpenseUsingDefaultConstructorAndSetters() {

        // Arrange
        UUID id = UUID.randomUUID();
        LocalDate date = LocalDate.now();

        Expense expense = new Expense();

        // Act
        expense.setId(id);
        expense.setTitle("Burger");
        expense.setAmount(BigDecimal.valueOf(200));
        expense.setCategory("Food");
        expense.setDate(date);

        // Assert
        assertEquals(id, expense.getId());
        assertEquals("Burger", expense.getTitle());
        assertEquals(BigDecimal.valueOf(200), expense.getAmount());
        assertEquals("Food", expense.getCategory());
        assertEquals(date, expense.getDate());
    }
}