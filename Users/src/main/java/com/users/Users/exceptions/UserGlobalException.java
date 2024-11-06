package com.users.Users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserGlobalException extends RuntimeException {

    public ProblemDetail toProblemdetail(){
        var problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        problemDetail.setTitle("User Internal server Error");

        return problemDetail;
    }
}
