package com.example.TaskDemo.Auth;

import com.example.TaskDemo.Dto.UserRegisterDto;
import com.example.TaskDemo.Exception.DuplicateEmailException;
import com.example.TaskDemo.Exception.UsernameAlreadyExistsException;
import com.example.TaskDemo.config.JwtService;
import com.example.TaskDemo.models.User;
import com.example.TaskDemo.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service


public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    public User register(User user){
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists.please choose a different username.");
        }
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }


    public String authenticate(User user){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );
        var userT=userRepository.findByUsername(user.getUsername()).orElseThrow();
        var jwtToken=jwtService.generateToken(userT);
        return jwtToken;
    }


}
