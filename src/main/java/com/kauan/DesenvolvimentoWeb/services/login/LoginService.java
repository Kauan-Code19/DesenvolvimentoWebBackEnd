package com.kauan.DesenvolvimentoWeb.services.login;

import com.kauan.DesenvolvimentoWeb.dtos.login.LoginDTO;
import com.kauan.DesenvolvimentoWeb.dtos.user.UserResponseDTO;
import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import com.kauan.DesenvolvimentoWeb.repositories.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    public UserResponseDTO loginUser(LoginDTO loginDTO) {
        UserEntity userEntity = userRepository.findByEmailAndPassword
                (loginDTO.getUserEmail(), loginDTO.getUserPassword());

        if (userEntity == null) {
            throw new EntityNotFoundException("Entidade não encontrada");
        }

        return new UserResponseDTO(userEntity);
    }
}
