package com.example.HocNao.models;

import jakarta.persistence.Column;
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
    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private boolean isCorrect;

    @Column(nullable = true)
    private int orderIndex;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
