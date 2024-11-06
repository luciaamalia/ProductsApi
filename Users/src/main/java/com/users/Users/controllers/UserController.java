package com.users.Users.controllers;

import com.users.Users.dtos.RequestUserDTO;
import com.users.Users.dtos.ResponseUserDTO;
import com.users.Users.models.UserModel;
import com.users.Users.services.UserServiceImplementation;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @PostMapping
    public ResponseEntity<RequestUserDTO> registerUser(@Valid @RequestBody RequestUserDTO userDTO){
        userServiceImplementation.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }
    @GetMapping
    public ResponseEntity<List<ResponseUserDTO>> listAllUsers(){
        List<ResponseUserDTO> users = userServiceImplementation.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<ResponseUserDTO> listUserById(@PathVariable UUID idUser){
        ResponseUserDTO user = userServiceImplementation.getUserById(idUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID idUser) {

        userServiceImplementation.getUserById(idUser);
        userServiceImplementation.deleteUserById(idUser);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<Object> updateUser(@PathVariable UUID idUser, @Valid @RequestBody RequestUserDTO dataRequestDTO) {

        ResponseUserDTO userDTO = userServiceImplementation.getUserById(idUser);

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);

        userServiceImplementation.updateUser(dataRequestDTO, userModel);

        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }

}
