package com.kauan.DesenvolvimentoWeb.dtos.user;

import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDTO {
    private String id;
    private String name;
    private String email;

    public UserResponseDTO(UserEntity userEntity) {
        id = userEntity.getId();
        name = userEntity.getName();
        email = userEntity.getEmail();
    }
}
