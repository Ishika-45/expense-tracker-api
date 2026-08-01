package com.ishika.expensetracker.controller;

import com.ishika.expensetracker.dto.CreateExpenseRequest;
import com.ishika.expensetracker.model.Expense;
import com.ishika.expensetracker.service.ExpenseService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(
            @Valid @RequestBody CreateExpenseRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(expenseService.addExpense(request));
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping(params = "category")
    public ResponseEntity<List<Expense>> getExpensesByCategory(
            @RequestParam String category) {

        return ResponseEntity.ok(expenseService.getExpensesByCategory(category));
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalExpenses() {
        return ResponseEntity.ok(expenseService.getTotalExpenses());
    }

    @GetMapping(value = "/total", params = "category")
    public ResponseEntity<BigDecimal> getTotalExpensesByCategory(
            @RequestParam String category) {

        return ResponseEntity.ok(
                expenseService.getTotalExpensesByCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(
            @PathVariable UUID id) {

        boolean deleted = expenseService.deleteExpense(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}