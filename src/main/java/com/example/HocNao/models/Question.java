package com.example.HocNao.models;

import java.util.List;

import com.example.HocNao.type.QuestionType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Question extends BaseEntity {
    private String content;
    private String imageUrl;
    private int point;
    private int timer;

    @ManyToOne
    @JoinColumn(name = "quizz_id")
    private Quizz quizz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Options> options;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type", nullable = false)
    private QuestionType questionType;
}
