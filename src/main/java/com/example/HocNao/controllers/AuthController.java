package com.example.HocNao.controllers;

import javax.naming.NameNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HocNao.dto.authDTO.LoginDTO;
import com.example.HocNao.dto.userDTO.UserPostDTO;
import com.example.HocNao.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody() LoginDTO loginDTO) throws NameNotFoundException {
        return authService.login(loginDTO);
    }

    @PostMapping("/register")
    public String register(@RequestBody() UserPostDTO postDTO) {
        return authService.register(postDTO);
    }
}
