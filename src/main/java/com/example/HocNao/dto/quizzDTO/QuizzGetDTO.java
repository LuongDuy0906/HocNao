package com.example.HocNao.dto.quizzDTO;

import com.example.HocNao.models.Quizz;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizzGetDTO {
    private String title;
    private String description;
    private String imageUrl;
    private String numbersOfQuestion;
    private String username;

    public QuizzGetDTO(Quizz quizz) {
        this.title = quizz.getTitle();
        this.description = quizz.getDescription();
        this.imageUrl = quizz.getImageUrl();
        this.numbersOfQuestion = quizz.getNumbersOfQuestion();
        this.username = quizz.getAuthor().getUsername();
    }
}
