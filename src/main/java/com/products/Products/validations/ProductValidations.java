package com.products.Products.validations;

import com.products.Products.exceptions.ProductExceptions;
import com.products.Products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductValidations extends ProductExceptions{

    @Autowired
    private ProductRepository productRepository;

    public void validateProductName(String name) {
        if (productRepository.existsByName(name)) {
            throw new ProductAlreadyExistsException("Esse produto já existe");
        }
    }
}
