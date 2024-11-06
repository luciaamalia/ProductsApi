package com.users.Users.services.interfaces;

import com.users.Users.dtos.RequestUserDTO;
import com.users.Users.dtos.ResponseUserDTO;
import com.users.Users.models.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserInterface {

    void registerUser(RequestUserDTO userDTO);

    List<ResponseUserDTO> getAllUsers();

    ResponseUserDTO getUserById (UUID idUser);

    void deleteUserById (UUID idUser);

    void updateUser(RequestUserDTO requestUserDTO, UserModel userModel);

}
