package com.example.UserRegisteration.config;

import com.example.UserRegisteration.Exception.UsernameAlreadyExistsException;
import com.example.UserRegisteration.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws UsernameAlreadyExistsException {
        User registeredUser = authenticationService.register(user);
        return ResponseEntity.ok("user registered");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }
}
