package com.users.Users.controllers;

import com.users.Users.dtos.RequestUserDTO;
import com.users.Users.dtos.ResponseUserDTO;
import com.users.Users.services.UserServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
