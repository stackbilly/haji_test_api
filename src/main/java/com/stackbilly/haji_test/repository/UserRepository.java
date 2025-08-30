package com.stackbilly.haji_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackbilly.haji_test.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
