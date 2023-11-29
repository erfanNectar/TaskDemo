package com.example.UserRegisteration.Service;

import com.example.UserRegisteration.Dto.UserGetDto;
import com.example.UserRegisteration.Dto.UserPostDto;
import com.example.UserRegisteration.Model.User;
import com.example.UserRegisteration.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserGetDto> getAllUsers() {
        List<User> user=userRepository.findAll();
        return user.stream()
                .map(this::convertToGetDto)
                .collect(Collectors.toList());

    }

    private UserGetDto convertToGetDto(User user) {
        UserGetDto userGetDto=new UserGetDto();
        BeanUtils.copyProperties(user,userGetDto);
        return userGetDto;
    }

    public UserGetDto createUser(UserPostDto userPostDto) {

            User user = convertToEntity(userPostDto);
            User savedUser = userRepository.save(user);
            return convertToGetDto(savedUser);
        }

    private User convertToEntity(UserPostDto userPostDto) {
        User user = new User();
        BeanUtils.copyProperties(userPostDto, user);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;

    }

}
