package com.example.TaskDemo.models;

import com.example.TaskDemo.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String passsword;

    @Enumerated(EnumType.STRING)
    private UserType userType;

}
