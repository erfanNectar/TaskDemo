package com.example.TaskDemo.services;

import com.example.TaskDemo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
 private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private String getIdFromUsername(String username){
        return String.valueOf(userRepository.findByUsername(username).get().getId());
    }


}
