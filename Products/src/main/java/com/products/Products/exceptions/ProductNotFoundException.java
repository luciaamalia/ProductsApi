package com.products.Products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProductNotFoundException extends ProductGlobalException {

    @Override
    public ProblemDetail toProblemdetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setDetail("Produto não existe");
        return problemDetail;
    }
}
