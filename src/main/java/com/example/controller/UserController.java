package com.example.controller;
import com.example.model.UserClass;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public List<UserClass> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserClass> getUserById(@PathVariable Long id) {
        Optional<UserClass> optionalUser = userService.getUserById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        UserClass user = optionalUser.get();
        return ResponseEntity.ok(user);
    }

    // Create a new user
    @PostMapping
    public UserClass createUser(@RequestBody UserClass user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String username, String password) {
        try {
            Optional<UserClass> optionalUser = userService.getUserByUsername(username);
            if (optionalUser.isEmpty()) {
                return ResponseEntity.status(401).body("Invalid username");
            }

            UserClass user = optionalUser.get();
            if (!password.equals(user.getPassword())) {
                return ResponseEntity.status(401).body("Invalid password");
            }

            return ResponseEntity.ok("Authenticated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<UserClass> updateUser(@PathVariable Long id, @RequestBody UserClass userDetails) {
        UserClass updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (!userService.deleteUser(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
