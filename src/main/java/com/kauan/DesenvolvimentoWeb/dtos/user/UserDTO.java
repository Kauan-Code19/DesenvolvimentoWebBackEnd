package com.kauan.DesenvolvimentoWeb.dtos.user;

import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {
    @NotEmpty
    private String name;

    @Email
    private String email;

    @NotEmpty
    private String password;
}
