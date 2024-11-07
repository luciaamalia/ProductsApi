package com.users.Users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserAlreadyExistsException extends UserGlobalException {

    private String detail;

    @Override
    public ProblemDetail toProblemdetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problemDetail.setDetail("Esse usuário já existe");
        return problemDetail;
    }
}
