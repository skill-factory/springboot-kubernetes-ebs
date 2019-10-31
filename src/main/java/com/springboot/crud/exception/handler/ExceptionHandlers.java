package com.springboot.crud.exception.handler;

import com.springboot.crud.exception.EmployeeErrorResponse;
import com.springboot.crud.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.name());
        employeeErrorResponse.setCode(HttpStatus.NOT_FOUND.value());
        employeeErrorResponse.setMessage(ex.getMessage());
        employeeErrorResponse.setTimestamp(new Date().toString());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.NOT_FOUND);
    }
}
