package com.kauan.DesenvolvimentoWeb.dtos.login;

import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDTO {
    @Email
    private String userEmail;

    @NotEmpty
    private String userPassword;

    public LoginDTO(UserEntity userEntity) {
        userEmail = userEntity.getEmail();
        userPassword = userEntity.getPassword();
    }
}
