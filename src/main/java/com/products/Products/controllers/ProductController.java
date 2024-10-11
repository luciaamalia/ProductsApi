package com.products.Products.controllers;

import com.products.Products.models.ProductModel;
import com.products.Products.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<ProductModel>> listarProdutos(){
        List<ProductModel> product = productService.listProducts();
        return ResponseEntity.ok(product);

    }
    @GetMapping("/{idProduct}")
    public ResponseEntity<Object>listProductById(@PathVariable UUID idProduct){
        Optional<ProductModel> product = productService.listProductById(idProduct);

        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Product Not Found");
        }
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Object> deleteProductById(@PathVariable UUID idProduct){
        Optional<ProductModel> product = productService.listProductById(idProduct);

        if(product.isPresent()){
            productService.deleteProductById(idProduct);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Product Not Found");
        }
    }
}
