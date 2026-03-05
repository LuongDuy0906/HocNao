package com.example.HocNao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HocNao.dto.quizzDTO.QuizzGetDTO;
import com.example.HocNao.dto.quizzDTO.QuizzPostDTO;
import com.example.HocNao.models.Quizz;
import com.example.HocNao.repositories.QuizzRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuizzService {
    private final QuizzRepository quizzRepository;

    public List<QuizzGetDTO> getAllQuizzes() {
        List<Quizz> quizzes = quizzRepository.findAll();
        List<QuizzGetDTO> quizzGetDTOs = new ArrayList<>();

        for (Quizz quizz : quizzes) {
            quizzGetDTOs.add(new QuizzGetDTO(quizz));
        }
        return quizzGetDTOs;
    }

    public QuizzGetDTO createQuizz(QuizzPostDTO quizzPostDTO) {
        Quizz newQuizz = new Quizz();

        newQuizz.setTitle(quizzPostDTO.getTitle());

        QuizzGetDTO savedQuizz = new QuizzGetDTO(quizzRepository.save(newQuizz));
        return savedQuizz;
    }
}
