package com.exampleiteration1.org.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ManufacturerExceptions {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ManufacturerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleManNotFoundException(ManufacturerNotFoundException ex){
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingFieldException.class)
    public ResponseEntity<ErrorResponse> handleMissingFieldEx(MissingFieldException ex){
        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getMessage());
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
}
