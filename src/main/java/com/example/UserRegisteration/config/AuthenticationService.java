package com.example.UserRegisteration.config;

import com.example.UserRegisteration.Exception.UsernameAlreadyExistsException;
import com.example.UserRegisteration.Model.User;
import com.example.UserRegisteration.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService, BCryptPasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }


    public String authenticate(User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        var userT = userRepository.findByUsername(user.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(userT);
        return jwtToken;

    }
    public User register(User user) throws UsernameAlreadyExistsException {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists. Please choose a different username.");
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
}
