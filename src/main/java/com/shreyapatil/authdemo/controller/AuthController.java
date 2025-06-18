package com.shreyapatil.authdemo.controller;

import com.shreyapatil.authdemo.model.User;
import com.shreyapatil.authdemo.repository.UserRepository;
import com.shreyapatil.authdemo.service.UserService;
import com.shreyapatil.authdemo.util.JwtUtil;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


import java.util.HashMap;
import java.util.Optional;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    
    @PostMapping("/register")
public ResponseEntity<?> register(@Valid @RequestBody User user) {
    try {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully with ID: " + savedUser.getId());
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody User loginRequest) {
    Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());

    if (optionalUser.isEmpty()) {
        return ResponseEntity.status(401).body("Invalid email or password");
    }

    User user = optionalUser.get();
    if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
        return ResponseEntity.status(401).body("Invalid email or password");
    }

    String token = jwtUtil.generateToken(user.getEmail());

    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    response.put("message", "Login successful");

    return ResponseEntity.ok(response);
}



}
