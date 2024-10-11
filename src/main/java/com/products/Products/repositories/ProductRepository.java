package com.products.Products.repositories;

import com.products.Products.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository <ProductModel, UUID>{
}
