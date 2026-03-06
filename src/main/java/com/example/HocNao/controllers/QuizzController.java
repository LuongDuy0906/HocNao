package com.example.HocNao.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HocNao.dto.quizzDTO.QuizzGetDTO;
import com.example.HocNao.services.QuizzService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quizzes")
@Tag(name = "Quizzes Controller", description = "Nhóm API dành cho quản lý câu hỏi")
public class QuizzController {
    private final QuizzService quizzService;

    @Operation(summary = "Lấy danh sách tất cả câu hỏi trên hệ thống", description = "Trả về danh sách tất cả câu hỏi trên hệ thống")
    @GetMapping("/")
    public ResponseEntity<?> getAllQuizzes(HttpServletRequest request) {
        List<QuizzGetDTO> response = new ArrayList<>();

        try {
            response = quizzService.getAllQuizzes();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
