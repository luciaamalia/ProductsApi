package com.users.Users.dtos;

import com.users.Users.enums.TypeProductsEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record ResponseProductsDTO (UUID idProduct, String name,
                                   TypeProductsEnum typeProduct, String description,
                                   BigDecimal price, Date dateCreation, Date dateUpdate){

}
