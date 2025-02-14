package com.products.Products.models;

import com.products.Products.enums.TypeProductsEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
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
    TypeProductsEnum typeProductsEnum;

    @Column
    String description;

    @Column
    BigDecimal price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    Date dateUpdate;

    @PrePersist
    protected void onCreate() {
        dateCreation = new Date();
        dateUpdate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdate = new Date();
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

}
