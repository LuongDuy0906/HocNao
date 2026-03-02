package com.example.HocNao.dto;

import com.example.HocNao.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetDTO {
    private String username;
    private String email;

    public UserGetDTO(User user) {
        if (user.getUsername() != null) {
            this.username = user.getUsername();
        }
        this.email = user.getEmail();
    }
}
