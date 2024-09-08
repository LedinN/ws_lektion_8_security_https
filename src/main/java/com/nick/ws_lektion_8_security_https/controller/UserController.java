package com.nick.ws_lektion_8_security_https.controller;

import com.nick.ws_lektion_8_security_https.model.User;
import com.nick.ws_lektion_8_security_https.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return ResponseEntity.ok(userRepository.save(user));
    }

}
