package com.example.TaskDemo.repository;

import com.example.TaskDemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
<<<<<<< HEAD
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
=======
    Optional<Object> findByEmail(String username);
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
}
