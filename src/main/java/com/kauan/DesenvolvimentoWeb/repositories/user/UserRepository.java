package com.kauan.DesenvolvimentoWeb.repositories.user;

import com.kauan.DesenvolvimentoWeb.entities.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
}
