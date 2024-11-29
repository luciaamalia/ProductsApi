package com.users.Users.dtos;

import com.users.Users.enums.TypeUserEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class RequestUserDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "O email não pode estar vazio")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotNull(message = "O login não pode estar vazio")
    private String login;

    @NotNull(message =  "O tipo de usuário é obrigatório" )
    private TypeUserEnum typeUser;

    @NotBlank(message = "O telefone não pode estar vazio")
    private String phone;

    @NotBlank(message = "O email é obrigatório")
    private String password;
}
