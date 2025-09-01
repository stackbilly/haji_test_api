package com.stackbilly.haji_test.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackbilly.haji_test.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);
}
