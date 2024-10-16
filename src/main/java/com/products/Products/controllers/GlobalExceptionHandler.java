package com.products.Products.controllers;

import com.products.Products.exceptions.ProductExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //a classe captura exceptions em tdo projeto
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductExceptions.ProductAlreadyExistsException.class)
    public ResponseEntity<String> handleProductAlreadyExists(ProductExceptions.ProductAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ProductExceptions.InvalidIdFormatException.class)
    public ResponseEntity<String> handleInvalidIdFormat(ProductExceptions.InvalidIdFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ProductExceptions.ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(ProductExceptions.ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductExceptions.InvalidFieldFormatException.class)
    public ResponseEntity<String> handleInvalidFieldFormat(ProductExceptions.InvalidFieldFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ProductExceptions.InvalidDataFormatException.class)
    public ResponseEntity<String> handleInvalidDataFormat(ProductExceptions.InvalidDataFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ProductExceptions.RequiredFieldMissingException.class)
    public ResponseEntity<String> handleRequiredFieldMissing(ProductExceptions.RequiredFieldMissingException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
