package com.example.HocNao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.HocNao.dto.userDTO.UserGetDTO;
import com.example.HocNao.dto.userDTO.UserPostDTO;
import com.example.HocNao.models.User;
import com.example.HocNao.repositories.UserRepository;
import com.example.HocNao.type.UserRole;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

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
        user.setPassword(passwordEncoder.encode(userPostDTO.getPassword()));
        if (userPostDTO.getRole() != null) {
            user.setRole(userPostDTO.getRole());
        } else {
            user.setRole(UserRole.USER);
        }
        UserGetDTO newUser = new UserGetDTO(userRepository.save(user));
        return newUser;
    }
}
