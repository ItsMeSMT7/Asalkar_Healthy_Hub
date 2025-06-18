package com.asalkar.healthyhub.repository;

import com.asalkar.healthyhub.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
