package com.users.Users.models;
import com.users.Users.enums.TypeProductsEnum;
import com.users.Users.enums.TypeUserEnum;
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
public class ProductUserModel {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idProduct;

    @Column
    String name;

    @Column(name = "type_product")
    @Enumerated(EnumType.STRING)
    TypeProductsEnum typeProduct;

    @Column
    String description;

    @Column
    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false) // FK apontando para a tabela users
    private UserModel user;

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
}
