package com.stackbilly.haji_test.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackbilly.haji_test.models.User;
import com.stackbilly.haji_test.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService uService) {
        this.userService = uService;
    }

    @GetMapping("/users")
    List<User> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/users/register")
    public User createUser(@RequestBody User nUser) {
        return userService.createUser(nUser);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable UUID id) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
