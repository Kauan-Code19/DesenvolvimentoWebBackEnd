package com.kauan.DesenvolvimentoWeb.dtos.user;

import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class userDTO {
    private String name;
    private String email;
    private String password;

    public userDTO(UserEntity userEntity) {
        name = userEntity.getName();
        email = userEntity.getEmail();
        password = userEntity.getPassword();
    }
}
