package com.users.Users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserAlreadyExistsException extends UserGlobalException {

    private String detail;

    public UserAlreadyExistsException(String detail){
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemdetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problemDetail.setDetail(this.detail);
        return problemDetail;
    }
}
