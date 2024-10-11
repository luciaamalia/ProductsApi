package com.products.Products.models;

import com.products.Products.enums.TypeProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "products")
@Table(name = "products")
public class ProductModel {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idProduct;

    @Column
    String name;

    @Column(name = "type_product")
    @Enumerated(EnumType.STRING)
    TypeProduct typeProduct;

    @Column
    String description;

    @Column
    BigDecimal price;
}
