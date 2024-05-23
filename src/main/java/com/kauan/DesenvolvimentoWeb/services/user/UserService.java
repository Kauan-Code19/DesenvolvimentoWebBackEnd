package com.kauan.DesenvolvimentoWeb.services.user;

import com.kauan.DesenvolvimentoWeb.dtos.user.UserDTO;
import com.kauan.DesenvolvimentoWeb.dtos.user.UserResponseDTO;
import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import com.kauan.DesenvolvimentoWeb.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());

        userEntity = userRepository.save(userEntity);

        return new UserResponseDTO(userEntity);
    }
}
