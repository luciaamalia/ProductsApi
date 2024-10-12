package com.products.Products.services;

import com.products.Products.models.ProductModel;
import com.products.Products.repositories.ProductRepository;
import com.products.Products.services.interfaces.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImplementation implements ProductInterface {

    @Autowired
    private ProductRepository productRepository;

   public void createProduct(ProductModel product){
       productRepository.save(product);
   }

    public List<ProductModel> getAllProducts(){
       return productRepository.findAll();
    }
    public Optional<ProductModel> getProductById (UUID idProduct){
        return productRepository.findById(idProduct);
    }
    public void deleteProductById(UUID idProduct){
            productRepository.deleteById(idProduct);
    }
    public void updateProduct(ProductModel product){
       productRepository.save(product);
    }

}
