package com.example.service;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;
import com.example.model.UserClass;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserClass> getAllUsers() {
        return userRepository.findAll();
    }

    public UserClass createUser(UserClass user) {
        return userRepository.save(user);
    }

    public Optional<UserClass> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserClass saveUser(UserClass user) {
        return userRepository.save(user);
    }

    public Optional<UserClass> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserClass> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserClass updateUser(Long id, UserClass userDetails) {
        Optional<UserClass> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserClass user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            return userRepository.save(user);
        }
        return null;
    }
}
