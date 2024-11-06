package com.users.Users.dtos;

import com.users.Users.enums.TypeUserEnum;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ResponseUserDTO {
    private UUID idUser;
    private String name;
    private String email;
    private TypeUserEnum typeUser;
}
