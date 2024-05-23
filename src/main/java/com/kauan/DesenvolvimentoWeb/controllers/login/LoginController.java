package com.kauan.DesenvolvimentoWeb.controllers.login;

import com.kauan.DesenvolvimentoWeb.dtos.login.LoginDTO;
import com.kauan.DesenvolvimentoWeb.dtos.user.UserResponseDTO;
import com.kauan.DesenvolvimentoWeb.services.login.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        UserResponseDTO userResponseDTO = loginService.loginUser(loginDTO);

        return ResponseEntity.ok(userResponseDTO);
    }
}
