package com.ishika.expensetracker.exception;


import jakarta.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;



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



        HttpServletRequest request =
                mock(HttpServletRequest.class);



        when(request.getRequestURI())
                .thenReturn("/expenses");



        GlobalExceptionHandler handler =
                new GlobalExceptionHandler();




        ResponseEntity<ErrorResponse> response =
                handler.handleValidationExceptions(
                        exception,
                        request
                );



        assertEquals(
                HttpStatus.BAD_REQUEST,
                response.getStatusCode()
        );



        assertNotNull(response.getBody());



        assertEquals(
                400,
                response.getBody().getStatus()
        );



        assertEquals(
                "Validation failed",
                response.getBody().getMessage()
        );



        assertEquals(
                "/expenses",
                response.getBody().getPath()
        );



        assertEquals(
                "Title is required",
                response.getBody()
                        .getErrors()
                        .get("title")
        );

    }

}