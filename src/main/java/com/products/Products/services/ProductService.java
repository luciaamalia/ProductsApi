package com.products.Products.services;

import com.products.Products.models.ProductModel;
import com.products.Products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

   public void createProduct(ProductModel product){
       productRepository.save(product);
   }
}
