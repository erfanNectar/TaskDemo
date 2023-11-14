package com.example.TaskDemo.repository;



import com.example.TaskDemo.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    Optional<Object> findByToken(String token);
}
