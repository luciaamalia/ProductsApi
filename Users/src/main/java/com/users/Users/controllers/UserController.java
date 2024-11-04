package com.users.Users.controllers;

import com.users.Users.dtos.RequestUserDTO;
import com.users.Users.services.UserServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserServiceImplementation userServiceImplementation;

//    @PostMapping
//    public ResponseEntity<RequestUserDTO> registerUser(@Valid @RequestBody RequestUserDTO userDTO){
//        userServiceImplementation.registerUser(userDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
//    }
}
