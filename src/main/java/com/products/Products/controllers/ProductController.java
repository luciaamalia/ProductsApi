package com.products.Products.controllers;

import com.products.Products.dtos.RequestProductDTO;
import com.products.Products.dtos.ResponseProductDTO;
import com.products.Products.models.ProductModel;
import com.products.Products.services.ProductServiceImplementation;
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
    private ProductServiceImplementation productServiceImplementation;

    @PostMapping
    public ResponseEntity<RequestProductDTO> cadastroProduto(@RequestBody RequestProductDTO product){
        productServiceImplementation.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDTO>> listarProdutos(){
        List<ResponseProductDTO> product = productServiceImplementation.getAllProducts();
        return ResponseEntity.ok(product);

    }
    @GetMapping("/{idProduct}")
    public ResponseEntity<Object>listProductById(@PathVariable UUID idProduct){
        Optional<ResponseProductDTO> product = productServiceImplementation.getProductById(idProduct);

        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Product Not Found");
        }
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Object> deleteProductById(@PathVariable UUID idProduct){
        Optional<ResponseProductDTO> product = productServiceImplementation.getProductById(idProduct);

        if(product.isPresent()){
            productServiceImplementation.deleteProductById(idProduct);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Product Not Found");
        }
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<Object> updateProduct(@PathVariable UUID idProduct, @RequestBody RequestProductDTO dataRequest){
        Optional<ResponseProductDTO> product = productServiceImplementation.getProductById(idProduct);
        if(product.isPresent()){

            ResponseProductDTO productUpdate = product.get();

            productUpdate.setName(dataRequest.getName());
            productUpdate.setPrice(dataRequest.getPrice());
            productUpdate.setDescription(dataRequest.getDescription());
            productUpdate.setTypeProduct(dataRequest.getTypeProduct());


          //  productServiceImplementation.updateProduct(productUpdate);
            return new ResponseEntity<>(productUpdate, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Product Not Found");
        }
    }
}