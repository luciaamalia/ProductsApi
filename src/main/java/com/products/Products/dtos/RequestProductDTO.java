package com.products.Products.dtos;

import com.products.Products.enums.TypeProduct;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class RequestProductDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private TypeProduct typeProduct;

}
