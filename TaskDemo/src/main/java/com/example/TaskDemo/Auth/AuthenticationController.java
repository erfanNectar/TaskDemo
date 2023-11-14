package com.example.TaskDemo.Auth;

import com.example.TaskDemo.Dto.UserRegisterDto;
import com.example.TaskDemo.models.User;
import com.example.TaskDemo.models.VerificationToken;
import com.example.TaskDemo.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthenticationController {
    private final AuthenticationService authenticationService;


    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService=authenticationService;
    }
    @PostMapping("/register")

    public ResponseEntity<String> register(@RequestBody User user){
        User registeredUser=authenticationService.register(user);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody User user){
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }
}
