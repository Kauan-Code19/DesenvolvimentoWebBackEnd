package com.kauan.DesenvolvimentoWeb.controllers.user;

import com.kauan.DesenvolvimentoWeb.dtos.user.UserDTO;
import com.kauan.DesenvolvimentoWeb.dtos.user.UserResponseDTO;
import com.kauan.DesenvolvimentoWeb.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
                .buildAndExpand(userResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(userResponseDTO);
    }
}
