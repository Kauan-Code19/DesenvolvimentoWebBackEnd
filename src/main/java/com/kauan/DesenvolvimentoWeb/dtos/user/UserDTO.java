package com.kauan.DesenvolvimentoWeb.dtos.user;

import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String password;
}
