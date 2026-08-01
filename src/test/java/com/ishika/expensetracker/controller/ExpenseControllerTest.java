package com.ishika.expensetracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ishika.expensetracker.dto.CreateExpenseRequest;
import com.ishika.expensetracker.model.Expense;
import com.ishika.expensetracker.service.ExpenseService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
@WebMvcTest(ExpenseController.class)
class ExpenseControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;

    @Autowired
    private ObjectMapper objectMapper;

        @Test
    void shouldAddExpense() throws Exception {

        CreateExpenseRequest request =
                new CreateExpenseRequest(
                        "Pizza",
                        BigDecimal.valueOf(350),
                        "Food",
                        LocalDate.now());

        Expense expense =
                new Expense(
                        UUID.randomUUID(),
                        "Pizza",
                        BigDecimal.valueOf(350),
                        "Food",
                        LocalDate.now());

        when(expenseService.addExpense(any()))
                .thenReturn(expense);

        mockMvc.perform(post("/expenses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Pizza"))
                .andExpect(jsonPath("$.category").value("Food"));
    }

        @Test
    void shouldReturnAllExpenses() throws Exception {

        Expense expense =
                new Expense(
                        UUID.randomUUID(),
                        "Pizza",
                        BigDecimal.valueOf(350),
                        "Food",
                        LocalDate.now());

        when(expenseService.getAllExpenses())
                .thenReturn(List.of(expense));

        mockMvc.perform(get("/expenses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Pizza"));
    }

        @Test
    void shouldReturnExpensesByCategory() throws Exception {

        Expense expense =
                new Expense(
                        UUID.randomUUID(),
                        "Pizza",
                        BigDecimal.valueOf(350),
                        "Food",
                        LocalDate.now());

        when(expenseService.getExpensesByCategory("Food"))
                .thenReturn(List.of(expense));

        mockMvc.perform(get("/expenses")
                        .param("category", "Food"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].category").value("Food"));
    }

        @Test
    void shouldReturnTotalExpenses() throws Exception {

        when(expenseService.getTotalExpenses())
                .thenReturn(BigDecimal.valueOf(1050));

        mockMvc.perform(get("/expenses/total"))
                .andExpect(status().isOk())
                .andExpect(content().string("1050"));
    }

        @Test
    void shouldReturnTotalExpensesByCategory() throws Exception {

        when(expenseService.getTotalExpensesByCategory("Food"))
                .thenReturn(BigDecimal.valueOf(550));

        mockMvc.perform(get("/expenses/total")
                        .param("category", "Food"))
                .andExpect(status().isOk())
                .andExpect(content().string("550"));
    }

        @Test
    void shouldDeleteExpense() throws Exception {

        UUID id = UUID.randomUUID();

        when(expenseService.deleteExpense(id))
                .thenReturn(true);

        mockMvc.perform(delete("/expenses/{id}", id))
                .andExpect(status().isNoContent());
    }
}

