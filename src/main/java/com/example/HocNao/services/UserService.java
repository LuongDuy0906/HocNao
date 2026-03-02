package com.example.HocNao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HocNao.dto.UserGetDTO;
import com.example.HocNao.dto.UserPostDTO;
import com.example.HocNao.models.User;
import com.example.HocNao.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserGetDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserGetDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            userDTOs.add(new UserGetDTO(user));
        }

        return userDTOs;
    }

    public UserGetDTO createUser(UserPostDTO userPostDTO) {
        User user = new User();
        user.setUsername(userPostDTO.getUsername());
        user.setEmail(userPostDTO.getEmail());
        user.setPassword(userPostDTO.getPassword());

        UserGetDTO newUser = new UserGetDTO(userRepository.save(user));
        return newUser;
    }
}
