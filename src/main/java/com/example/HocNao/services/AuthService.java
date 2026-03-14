package com.example.HocNao.services;

import javax.naming.NameNotFoundException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.HocNao.dto.authDTO.LoginDTO;
import com.example.HocNao.dto.userDTO.UserGetDTO;
import com.example.HocNao.dto.userDTO.UserPostDTO;
import com.example.HocNao.models.User;
import com.example.HocNao.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;
    private final UserService userService;

    public String login(LoginDTO loginDTO) throws NameNotFoundException {
        User existUser = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new NameNotFoundException("Khong tim thay nguoi dung"));

        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generatedToken(existUser.getUsername());
        }

        return "failed";
    }

    public String register(UserPostDTO userPostDTO) {
        UserGetDTO savedUser = userService.createUser(userPostDTO);

        return jwtService.generatedToken(savedUser.getUsername());
    }
}
