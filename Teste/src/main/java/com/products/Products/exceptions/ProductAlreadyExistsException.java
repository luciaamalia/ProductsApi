package com.products.Products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProductAlreadyExistsException extends ProductGlobalException {

    private String detail;

    public ProductAlreadyExistsException(String detail){
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemdetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problemDetail.setDetail(this.detail);
        return problemDetail;
    }
}
