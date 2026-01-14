package org.thexeler.srpgsoserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thexeler.srpgsoserver.request.LoginRequest;
import org.thexeler.srpgsoserver.response.LoginResponse;
import org.thexeler.srpgsoserver.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (userService.validateUser(request.getUsername(), request.getPassword())) {
            return ResponseEntity.ok(new LoginResponse("Login successful", generateToken()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    private String generateToken() {
        return java.util.UUID.randomUUID().toString();
    }
}
