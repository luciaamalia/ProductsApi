package com.products.Products.controllers;

import com.products.Products.models.ProductModel;
import com.products.Products.repositories.ProductRepository;
import com.products.Products.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductModel> cadastroProduto(@RequestBody ProductModel product){
        productService.createProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);

    }
}
