package com.products.Products.controllers;

import com.products.Products.dtos.RequestProductDTO;
import com.products.Products.dtos.ResponseProductDTO;
import com.products.Products.models.ProductModel;
import com.products.Products.services.ProductServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImplementation productServiceImplementation;

    @PostMapping
    public ResponseEntity<RequestProductDTO> registerProduct(@Valid @RequestBody RequestProductDTO productDTO){
        productServiceImplementation.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDTO>> ListAllProducts(){
        List<ResponseProductDTO> products = productServiceImplementation.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);

    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<ResponseProductDTO> listProductById(@PathVariable UUID idProduct) {
        ResponseProductDTO product = productServiceImplementation.getProductById(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Object> deleteProduct(@PathVariable UUID idProduct) {

        productServiceImplementation.getProductById(idProduct);
        productServiceImplementation.deleteProductById(idProduct);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<Object> updateProduct(@PathVariable UUID idProduct, @Valid @RequestBody RequestProductDTO dataRequestDTO) {

        ResponseProductDTO productDTO = productServiceImplementation.getProductById(idProduct);

        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDTO, productModel);

        productServiceImplementation.updateProduct(dataRequestDTO, productModel);

        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }
}