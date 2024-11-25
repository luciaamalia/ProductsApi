package com.users.Users.services;

import com.users.Users.dtos.RequestUserDTO;
import com.users.Users.dtos.ResponseUserDTO;
import com.users.Users.exceptions.UserAlreadyExistsException;
import com.users.Users.exceptions.UserNotFoundException;
import com.users.Users.models.UserModel;
import com.users.Users.repositories.UserRepository;
import com.users.Users.services.interfaces.UserInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(RequestUserDTO requestUserDTO) {

        if(userRepository.existsByName(requestUserDTO.getName())){
            throw new UserAlreadyExistsException();
        }

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(requestUserDTO, userModel);

        userRepository.save(userModel);
    }

    @Override
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

    @Override
    public ResponseUserDTO getUserById(UUID idUser) {
        if (!userRepository.existsById(idUser)){
            throw new UserNotFoundException();
        }
        return userRepository.findById(idUser)
                .map(users ->        {
                    ResponseUserDTO responseUserDTO = new ResponseUserDTO();
                    BeanUtils.copyProperties(users, responseUserDTO);
                    return responseUserDTO;
                })
                .orElseThrow();
    }

    @Override
    public void deleteUserById(UUID idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public void updateUser(RequestUserDTO requestUserDTO, UserModel userModel) {

        BeanUtils.copyProperties(requestUserDTO, userModel);
        userModel.setDateUpdate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        userRepository.save(userModel);
    }

}
