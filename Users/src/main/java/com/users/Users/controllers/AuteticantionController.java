package com.users.Users.controllers;

import com.users.Users.dtos.RequestLoginDTO;
import com.users.Users.dtos.ResponseTokenDTO;
import com.users.Users.models.UserModel;
import com.users.Users.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuteticantionController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid RequestLoginDTO data)  {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.token((UserModel) authentication.getPrincipal());

        return ResponseEntity.ok(new ResponseTokenDTO(tokenJWT));
    }
}
