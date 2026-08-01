package com.ishika.expensetracker.exception;


import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;



@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(

            MethodArgumentNotValidException ex,
            HttpServletRequest request) {



        Map<String,String> errors = new HashMap<>();


        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );



        ErrorResponse response =
                new ErrorResponse(

                        LocalDateTime.now(),

                        HttpStatus.BAD_REQUEST.value(),

                        "Validation failed",

                        request.getRequestURI(),

                        errors

                );



        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);

    }





    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(

            Exception ex,
            HttpServletRequest request) {



        ErrorResponse response =
                new ErrorResponse(

                        LocalDateTime.now(),

                        HttpStatus.INTERNAL_SERVER_ERROR.value(),

                        "Something went wrong",

                        request.getRequestURI(),

                        null

                );



        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);

    }


}