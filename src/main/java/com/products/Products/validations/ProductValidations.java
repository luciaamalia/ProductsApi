package com.products.Products.validations;

import com.products.Products.exceptions.ProductExceptions;
import org.springframework.stereotype.Component;

@Component
public class ProductValidations {
    public void validateProduct(Product product) {
        // Validação de campos obrigatórios
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new ProductExceptions.RequiredFieldMissingException("name");
        }
        if (product.getPrice() == null) {
            throw new ProductExceptions.RequiredFieldMissingException("price");
        }
        if (product.getTypeProduct() == null || product.getTypeProduct().isEmpty()) {
            throw new ProductExceptions.RequiredFieldMissingException("typeProduct");
        }
    }
}
