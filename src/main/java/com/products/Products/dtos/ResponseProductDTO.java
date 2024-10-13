package com.products.Products.dtos;

import com.products.Products.enums.TypeProduct;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ResponseProductDTO {
    private UUID idProduct;
    private String name;
    private String description;
    private BigDecimal price;
    private TypeProduct typeProduct;
}
