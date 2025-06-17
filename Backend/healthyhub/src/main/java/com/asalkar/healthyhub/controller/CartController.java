package com.asalkar.healthyhub.controller;

import com.asalkar.healthyhub.model.CartItem;
import com.asalkar.healthyhub.model.User;
import com.asalkar.healthyhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add/{email}")
    public String addItemToCart(@PathVariable String email, @RequestBody CartItem item) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.getCart().add(item);
            userRepository.save(user);
            return "Item added to cart!";
        } else {
            return "User not found.";
        }
    }

    @GetMapping("/{email}")
    public Object viewCart(@PathVariable String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.map(User::getCart).orElse("User not found.");
    }
}
