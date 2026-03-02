package com.example.HocNao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile extends BaseEntity {

    private String avatarUrl;
    private String description;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
