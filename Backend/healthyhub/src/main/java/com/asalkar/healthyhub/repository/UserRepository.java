package com.asalkar.healthyhub.repository;

import com.asalkar.healthyhub.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
