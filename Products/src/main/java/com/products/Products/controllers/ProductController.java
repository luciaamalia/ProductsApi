package com.products.Products.controllers;

import com.products.Products.dtos.RequestProductDTO;
import com.products.Products.dtos.ResponseProductDTO;
import com.products.Products.exceptions.ProductAlreadyExistsException;
import com.products.Products.models.ProductModel;
import com.products.Products.services.ProductServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ProductServiceImplementation productServiceImplementation;

    @PostMapping
    public ResponseEntity<RequestProductDTO> registerProduct(@Valid @RequestBody RequestProductDTO productDTO){

        try{
            productServiceImplementation.createProduct(productDTO);
            String message = "Produto criado: " + productDTO.getName();
            kafkaTemplate.send("products", message);

            return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
        } catch (ProductAlreadyExistsException e) {
            // Trata a exceção se o produto já existir
            System.out.println("Erro: Produto já existe - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            // Trata outras exceções que possam ocorrer
            System.out.println("Erro ao criar produto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

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