package com.asalkar.healthyhub.controller;

import com.asalkar.healthyhub.model.Cart;
import com.asalkar.healthyhub.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable String userId) {
        return cartRepository.findByUserId(userId);
    }
}
