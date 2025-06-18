@PostMapping("/cart/add")
public ResponseEntity<?> addToCart(@RequestBody CartRequest request) {
    Optional<User> userOpt = userRepository.findByEmail(request.getUserEmail());
    if (userOpt.isEmpty()) return ResponseEntity.status(404).body("User not found");

    Cart cart = cartRepository.findByUserEmail(request.getUserEmail())
                   .orElse(new Cart(request.getUserEmail(), new ArrayList<>()));

    // Add product logic
    cart.getItems().addAll(request.getItems());
    cartRepository.save(cart);
    return ResponseEntity.ok(Map.of("success", true, "message", "Product added to cart"));
}
