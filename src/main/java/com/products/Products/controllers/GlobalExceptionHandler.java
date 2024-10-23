package com.products.Products.controllers;

import com.products.Products.exceptions.ProductExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //a classe captura exceptions em tdo projeto
public class GlobalExceptionHandler extends ProductExceptions {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<String> handleProductAlreadyExists(ProductAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidIdFormatException.class)
    public ResponseEntity<String> handleInvalidIdFormat(InvalidIdFormatException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidFieldFormatException.class)
    public ResponseEntity<String> handleInvalidFieldFormat(InvalidFieldFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidDataFormatException.class)
    public ResponseEntity<String> handleInvalidDataFormat(InvalidDataFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RequiredFieldMissingException.class)
    public ResponseEntity<String> handleRequiredFieldMissing(RequiredFieldMissingException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleEnumInvalid(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O valor de typeProduct é inválido. Valores permitidos: FOOD, ELECTRONICS, CLOTHING");
    }
}
