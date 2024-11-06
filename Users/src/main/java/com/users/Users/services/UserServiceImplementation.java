package com.users.Users.services;

import com.users.Users.dtos.RequestUserDTO;
import com.users.Users.dtos.ResponseUserDTO;
import com.users.Users.models.UserModel;
import com.users.Users.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation {

    @Autowired
    private UserRepository userRepository;


    public void registerUser(RequestUserDTO requestUserDTO) {

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(requestUserDTO, userModel);

        userRepository.save(userModel);
    }

    public List<ResponseUserDTO> getAllUsers(){
        List<UserModel> users = userRepository.findAll();

        return users.stream()
                .map(userModel -> {
                    ResponseUserDTO userDTO = new ResponseUserDTO();
                    BeanUtils.copyProperties(userModel, userDTO);
                    return userDTO;
                })
                .collect(Collectors.toList());
    }
}
