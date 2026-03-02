package com.example.HocNao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Options extends BaseEntity {
    private String content;
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
