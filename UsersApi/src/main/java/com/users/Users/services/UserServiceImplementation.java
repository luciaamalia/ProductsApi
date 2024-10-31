package com.users.Users.services;

import com.users.Users.dtos.RequestUserDTO;
import com.users.Users.models.UserModel;
import com.users.Users.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplementation {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(RequestUserDTO requestUserDTO) {

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(requestUserDTO, userModel);

        userRepository.save(userModel);
    }
}
