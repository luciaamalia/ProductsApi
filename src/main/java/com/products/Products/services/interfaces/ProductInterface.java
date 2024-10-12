package com.products.Products.services.interfaces;

import com.products.Products.models.ProductModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductInterface {

    void createProduct(ProductModel product);

    List<ProductModel> getAllProducts();

    Optional<ProductModel> getProductById(UUID idProduct);

     void deleteProductById (UUID idProduct);

     void updateProduct(ProductModel product);
}
