package com.example.HocNao.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Quizz extends BaseEntity {
    private String title;
    private String description;
    private String imageUrl;

    @Column(name = "numbers_of_question")
    private String numbersOfQuestion;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "quizz", cascade = CascadeType.ALL)
    private List<Question> questions;
}
