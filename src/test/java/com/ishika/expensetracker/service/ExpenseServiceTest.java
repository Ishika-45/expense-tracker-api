package com.ishika.expensetracker.service;

import com.ishika.expensetracker.dto.CreateExpenseRequest;
import com.ishika.expensetracker.model.Expense;
import com.ishika.expensetracker.repository.ExpenseRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @Test
    void shouldAddExpense() {

        CreateExpenseRequest request = new CreateExpenseRequest(
                "Pizza",
                BigDecimal.valueOf(350),
                "Food",
                LocalDate.now()
        );

        Expense savedExpense = new Expense(
                UUID.randomUUID(),
                request.getTitle(),
                request.getAmount(),
                request.getCategory(),
                request.getDate()
        );

        when(expenseRepository.save(any(Expense.class)))
                .thenReturn(savedExpense);

        Expense result = expenseService.addExpense(request);

        assertNotNull(result);
        assertEquals("Pizza", result.getTitle());
        assertEquals(BigDecimal.valueOf(350), result.getAmount());

        verify(expenseRepository).save(any(Expense.class));
    }

    @Test
    void shouldGetAllExpenses() {

        List<Expense> expenses = List.of(
                new Expense(
                        UUID.randomUUID(),
                        "Pizza",
                        BigDecimal.valueOf(350),
                        "Food",
                        LocalDate.now()
                )
        );

        when(expenseRepository.findAll()).thenReturn(expenses);

        List<Expense> result = expenseService.getAllExpenses();

        assertEquals(1, result.size());
        assertEquals("Pizza", result.get(0).getTitle());

        verify(expenseRepository).findAll();
    }

    @Test
    void shouldGetExpensesByCategory() {

        List<Expense> expenses = List.of(
                new Expense(
                        UUID.randomUUID(),
                        "Pizza",
                        BigDecimal.valueOf(350),
                        "Food",
                        LocalDate.now()
                )
        );

        when(expenseRepository.findByCategory("Food"))
                .thenReturn(expenses);

        List<Expense> result =
                expenseService.getExpensesByCategory("Food");

        assertEquals(1, result.size());
        assertEquals("Food", result.get(0).getCategory());

        verify(expenseRepository).findByCategory("Food");
    }

    @Test
    void shouldCalculateTotalExpenses() {

        List<Expense> expenses = List.of(
                new Expense(UUID.randomUUID(),"Pizza",BigDecimal.valueOf(350),"Food",LocalDate.now()),
                new Expense(UUID.randomUUID(),"Burger",BigDecimal.valueOf(200),"Food",LocalDate.now())
        );

        when(expenseRepository.findAll()).thenReturn(expenses);

        BigDecimal total = expenseService.getTotalExpenses();

        assertEquals(BigDecimal.valueOf(550), total);

        verify(expenseRepository).findAll();
    }

    @Test
    void shouldCalculateTotalExpensesByCategory() {

        List<Expense> expenses = List.of(
                new Expense(UUID.randomUUID(),"Pizza",BigDecimal.valueOf(350),"Food",LocalDate.now()),
                new Expense(UUID.randomUUID(),"Burger",BigDecimal.valueOf(200),"Food",LocalDate.now())
        );

        when(expenseRepository.findByCategory("Food"))
                .thenReturn(expenses);

        BigDecimal total =
                expenseService.getTotalExpensesByCategory("Food");

        assertEquals(BigDecimal.valueOf(550), total);

        verify(expenseRepository).findByCategory("Food");
    }

    @Test
    void shouldDeleteExpense() {

        UUID id = UUID.randomUUID();

        when(expenseRepository.deleteById(id))
                .thenReturn(true);

        boolean deleted = expenseService.deleteExpense(id);

        assertTrue(deleted);

        verify(expenseRepository).deleteById(id);
    }

}