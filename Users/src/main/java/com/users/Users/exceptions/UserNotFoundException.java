package com.users.Users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserNotFoundException extends UserGlobalException {

    @Override
    public ProblemDetail toProblemdetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setDetail("User not found");
        return problemDetail;
    }
}
