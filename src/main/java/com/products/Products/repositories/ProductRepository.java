package com.products.Products.repositories;

import com.products.Products.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository <ProductModel, UUID>{
    boolean existsByName(String name);
}
