package com.example.HocNao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HocNao.models.Quizz;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Integer> {

}
