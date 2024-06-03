package com.kauan.DesenvolvimentoWeb.controllers.user;

import com.kauan.DesenvolvimentoWeb.dtos.user.UserDTO;
import com.kauan.DesenvolvimentoWeb.dtos.user.UserResponseDTO;
import com.kauan.DesenvolvimentoWeb.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable String userId) {
        UserResponseDTO userResponseDTO = userService.getUser(userId);

        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> userResponseDTO = userService.getAllUsers();

        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable String userId,
                                                      @Valid @RequestBody UserDTO userDTO) {
        UserResponseDTO userResponseDTO = userService.updateUser(userId, userDTO);

        return ResponseEntity.ok(userResponseDTO);
    }
}
