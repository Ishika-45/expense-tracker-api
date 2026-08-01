package com.ishika.expensetracker.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {


    @Test
    void shouldHandleValidationException() {


        FieldError fieldError =
                new FieldError(
                        "expenseRequest",
                        "title",
                        "Title is required"
                );


        BindingResult bindingResult =
                new org.springframework.validation.BeanPropertyBindingResult(
                        new Object(),
                        "expenseRequest"
                );

        bindingResult.addError(fieldError);


        MethodArgumentNotValidException exception =
                new MethodArgumentNotValidException(
                        null,
                        bindingResult
                );


        GlobalExceptionHandler handler =
                new GlobalExceptionHandler();


        ResponseEntity<Map<String, String>> response =
                handler.handleValidationExceptions(exception);


        assertEquals(
                HttpStatus.BAD_REQUEST,
                response.getStatusCode()
        );


        assertNotNull(response.getBody());


        assertEquals(
                "Title is required",
                response.getBody().get("title")
        );
    }
}