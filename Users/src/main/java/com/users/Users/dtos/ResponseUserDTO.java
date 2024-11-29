package com.users.Users.dtos;

import com.users.Users.enums.TypeUserEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ResponseUserDTO {
    private UUID idUser;
    private String name;
    private String email;
    private String login;
    private String phone;
    private TypeUserEnum typeUser;
    private Date dateCreation;
    private Date dateUpdate;
}
