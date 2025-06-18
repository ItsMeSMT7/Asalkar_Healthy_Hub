package com.asalkar.healthyhub.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "carts")
public class Cart {
    @Id
    private String id;
    private String userId;
    private List<Item> items;

    public static class Item {
        private String productId;
        private int quantity;

        // Getters and setters
    }

    // Getters and setters
}
