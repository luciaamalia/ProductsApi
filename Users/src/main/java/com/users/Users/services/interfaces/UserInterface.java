package com.users.Users.services.interfaces;

import com.users.Users.dtos.RequestUserDTO;
import com.users.Users.dtos.ResponseUserDTO;

import java.util.List;

public interface UserInterface {

    void registerUser(RequestUserDTO userDTO);
    List<ResponseUserDTO> getAllUsers();

}
