package com.products.Products.services;

import com.products.Products.models.ProductModel;
import com.products.Products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

   public void createProduct(ProductModel product){
       productRepository.save(product);
   }

    public List<ProductModel> listProducts(){
       return productRepository.findAll();
    }
    public Optional<ProductModel> listProductById(UUID idProduct){
        return productRepository.findById(idProduct);
    }
    public void deleteProductById(UUID idProduct){
            productRepository.deleteById(idProduct);
    }
    public void updateProduct(ProductModel product){
       productRepository.save(product);
    }

}
