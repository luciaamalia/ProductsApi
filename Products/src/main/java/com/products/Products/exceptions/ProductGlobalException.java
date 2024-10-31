package com.products.Products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProductGlobalException extends RuntimeException {

    public ProblemDetail toProblemdetail(){
        var problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        problemDetail.setTitle("Product Internal server Error");

        return problemDetail;
    }
}
