package com.example.HocNao.dto.quizzDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizzPostDTO {
    @NotBlank(message = "Tên bộ đề không được để trống!")
    private String title;

    @NotBlank(message = "Mô tả bộ đề không được để trống")
    private String description;

    private String imageUrl;
}
