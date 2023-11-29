package com.example.UserRegisteration.Controller;

import com.example.UserRegisteration.Dto.UserGetDto;
import com.example.UserRegisteration.Dto.UserPostDto;
import com.example.UserRegisteration.Model.User;
import com.example.UserRegisteration.Service.UserService;
import com.example.UserRegisteration.Util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getuser")
    public ResponseEntity<Response<List<UserGetDto>>> getAllUser(){
        List<UserGetDto> users = userService.getAllUsers();
        Response<List<UserGetDto>> response = Response.<List<UserGetDto>>builder()
                .timeStamp(LocalDateTime.now())
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("Users retrieved successfully")
                .data(users)
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping("/adduser")
    public ResponseEntity<Response<UserGetDto>> createUser(@RequestBody UserPostDto userPostDto) {

        UserGetDto createdUser = userService.createUser(userPostDto);

        Response<UserGetDto> response = Response.<UserGetDto>builder()
                .timeStamp(LocalDateTime.now())
                .statusCode(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED)
                .message("User created successfully")
                .data(createdUser)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
