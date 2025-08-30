package com.stackbilly.haji_test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackbilly.haji_test.exceptions.UserNotFoundException;
import com.stackbilly.haji_test.models.User;
import com.stackbilly.haji_test.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository uRepository) {
        this.userRepository = uRepository;
    }

    @GetMapping("/api/users")
    List<User> allUsers() {
        return userRepository.findAll();
    }

    @GetMapping("api/users/{id}")
    User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/api/users")
    User newUser(@RequestBody User nUser) {
        return userRepository.save(nUser);
    }

    @PutMapping("/api/users/{id}")
    User updateUser(@RequestBody User nUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(nUser.getFirstName());
                    user.setLastName(nUser.getLastName());
                    user.setAddress(nUser.getAddress());
                    user.setEmail(nUser.getEmail());
                    user.setMobile(nUser.getMobile());
                    user.setUserRole(nUser.getUserRole());
                    user.setEmailNotification(nUser.isEmailNotification());
                    user.setPushNotification(nUser.isPushNotification());
                    user.setSmsNotification(nUser.isSmsNotification());
                    user.setUpdatedAt(nUser.getUpdatedAt());
                    user.setFcmToken(nUser.getFcmToken());
                    return userRepository.save(user);
                }).orElseGet(() -> {
                    return userRepository.save(nUser);
                });
    }

    @DeleteMapping("/api/user/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
