package com.users.Users.controllers;

import com.users.Users.exceptions.UserGlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserGlobalException.class)
    public ProblemDetail handleProductException(UserGlobalException e){
        return e.toProblemdetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        var fieldErros = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Os campos na lista abaixo são obrigatórios");
        pb.setProperty("Campos obrigatórios", fieldErros);

        return pb;
    }

    private record InvalidParam(String name, String reason){}
}
