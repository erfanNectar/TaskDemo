package com.example.UserRegisteration.Dto;

import com.example.UserRegisteration.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserGetDto {
    private Long id;
    private String name;
    private String email;
    private Gender gender;

}
