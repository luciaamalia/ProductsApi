package com.users.Users.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLoginDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;

}
