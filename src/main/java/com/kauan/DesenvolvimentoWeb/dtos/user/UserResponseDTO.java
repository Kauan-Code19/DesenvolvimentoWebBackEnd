package com.kauan.DesenvolvimentoWeb.dtos.user;

import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDTO {
    private String name;
    private String email;
    private String password;

    public UserResponseDTO(UserEntity userEntity) {
        name = userEntity.getName();
        email = userEntity.getEmail();
        password = userEntity.getPassword();
    }
}
