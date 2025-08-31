package com.stackbilly.haji_test.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackbilly.haji_test.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
