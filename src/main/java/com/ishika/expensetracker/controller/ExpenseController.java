package com.ishika.expensetracker.controller;

import com.ishika.expensetracker.dto.CreateExpenseRequest;
import com.ishika.expensetracker.model.Expense;
import com.ishika.expensetracker.service.ExpenseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/expenses")
@Tag(
        name = "Expense Management",
        description = "APIs for creating, retrieving and deleting expenses"
)
public class ExpenseController {

    private final ExpenseService expenseService;


    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    @Operation(
            summary = "Create a new expense",
            description = "Creates a new expense record"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Expense created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid expense data"
            )
    })
    @PostMapping
    public ResponseEntity<Expense> addExpense(
            @Valid @RequestBody CreateExpenseRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expenseService.addExpense(request));
    }



    @Operation(
            summary = "Get all expenses",
            description = "Returns all expenses stored in the system"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Expenses fetched successfully"
    )
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {

        return ResponseEntity.ok(
                expenseService.getAllExpenses()
        );
    }



    @Operation(
            summary = "Get expenses by category",
            description = "Returns expenses filtered by category"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Expenses fetched successfully"
    )
    @GetMapping(params = "category")
    public ResponseEntity<List<Expense>> getExpensesByCategory(
            @RequestParam String category) {

        return ResponseEntity.ok(
                expenseService.getExpensesByCategory(category)
        );
    }



    @Operation(
            summary = "Get total expenses",
            description = "Calculates total spending amount"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Total calculated successfully"
    )
    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalExpenses() {

        return ResponseEntity.ok(
                expenseService.getTotalExpenses()
        );
    }



    @Operation(
            summary = "Get total expenses by category",
            description = "Calculates total spending for a specific category"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Total calculated successfully"
    )
    @GetMapping(value = "/total", params = "category")
    public ResponseEntity<BigDecimal> getTotalExpensesByCategory(
            @RequestParam String category) {

        return ResponseEntity.ok(
                expenseService.getTotalExpensesByCategory(category)
        );
    }



    @Operation(
            summary = "Delete an expense",
            description = "Deletes an expense using its UUID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Expense deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Expense not found"
            )
    })
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