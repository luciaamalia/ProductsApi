package com.users.Users.dtos;

import com.users.Users.enums.TypeUserEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUserDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotNull(message =  "O tipo de usuário é obrigatório" )
    private TypeUserEnum typeUser;
}
