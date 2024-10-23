package com.products.Products.dtos;

import com.products.Products.enums.TypeProduct;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;

@Getter
@Setter
public class RequestProductDTO {

    @NotNull
    private String name;

    private String description;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
    private BigDecimal price;

    @NotNull
    private TypeProduct typeProduct;

}
