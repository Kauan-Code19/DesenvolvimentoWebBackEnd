package com.kauan.DesenvolvimentoWeb.services.user;

import com.kauan.DesenvolvimentoWeb.dtos.user.UserDTO;
import com.kauan.DesenvolvimentoWeb.dtos.user.UserResponseDTO;
import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import com.kauan.DesenvolvimentoWeb.repositories.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public UserResponseDTO getUser(String userId) {
        Optional<UserEntity> optionalUserEntityuserEntity = userRepository.findById(userId);

        if (optionalUserEntityuserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntityuserEntity.get();

            return new UserResponseDTO(userEntity);
        } else {
            throw new EntityNotFoundException("User not found with id " + userId);
        }
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsers() {
        List<UserEntity> userEntities =  userRepository.findAll();

        List<UserResponseDTO> userResponseDTOS = userEntities.stream()
                .map(UserResponseDTO::new).toList();

        return userResponseDTOS;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public UserResponseDTO updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> optionalUserEntityuserEntity = userRepository.findById(userId);

        if (optionalUserEntityuserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntityuserEntity.get();

            userEntity.setName(userDTO.getName());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setPassword(userDTO.getPassword());

            userEntity =  userRepository.save(userEntity);

            return new UserResponseDTO(userEntity);
        } else {
            throw new EntityNotFoundException("User not found with id " + userId);
        }
    }
}
