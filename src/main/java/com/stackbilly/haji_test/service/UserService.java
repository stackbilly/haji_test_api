package com.stackbilly.haji_test.service;

import com.stackbilly.haji_test.models.User;
import com.stackbilly.haji_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return repository.findById(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(UUID user_id) {
        repository.deleteById(user_id);
    }

    public User updateUser(User nUser) {
        return repository.findById(nUser.getUid())
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
                    return repository.save(user);
                }).orElseGet(() -> {
                    return repository.save(nUser);
                });
    }
}
