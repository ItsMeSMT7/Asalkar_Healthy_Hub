package com.asalkar.healthyhub.repository;

import com.asalkar.healthyhub.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByUserId(String userId);
}
