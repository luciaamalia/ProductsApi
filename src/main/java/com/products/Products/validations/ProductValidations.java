package com.products.Products.validations;

import com.products.Products.dtos.RequestProductDTO;
import com.products.Products.exceptions.ProductExceptions;
import com.products.Products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductValidations extends ProductExceptions{

    @Autowired
    private ProductRepository productRepository;

    public void validateProductName(String name) {
        if (productRepository.existsByName(name)) {
            throw new ProductAlreadyExistsException("Esse produto já existe");
        }
    }
    public void validateIdFormat(UUID idProduct) {
      if(idProduct == null){
          throw new IllegalArgumentException("ID do produto é inválido");
      }
    }

    public void productNotFoundException(UUID idProduct){
        if(!productRepository.existsById(idProduct)){
          throw new ProductAlreadyExistsException("Produto não encontrado ");
        }
    }

    public void validateRequestBody(RequestProductDTO requestProductDTO) {
        if (requestProductDTO == null) {
            throw new InvalidFieldFormatException("corpo da requisição");
        }

    }
}
