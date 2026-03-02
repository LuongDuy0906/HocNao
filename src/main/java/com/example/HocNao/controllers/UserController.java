package com.example.HocNao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HocNao.dto.UserGetDTO;
import com.example.HocNao.dto.UserPostDTO;
import com.example.HocNao.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "Nhóm API dành cho quản lý người dùng")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Lấy danh sách tất cả người dùng", description = "Trả về danh sách tất cả người dùng trong hệ thống")
    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        List<UserGetDTO> userDTOs = new ArrayList<>();
        try {
            userDTOs = userService.getAllUsers();
            return new ResponseEntity<>(userDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Tạo người dùng mới", description = "Tạo một người dùng mới với thông tin được cung cấp")
    @PostMapping("/")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserPostDTO userPostDTO) {
        UserGetDTO newUser;
        try {
            newUser = userService.createUser(userPostDTO);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
