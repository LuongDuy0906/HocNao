package com.example.HocNao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HocNao.models.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
