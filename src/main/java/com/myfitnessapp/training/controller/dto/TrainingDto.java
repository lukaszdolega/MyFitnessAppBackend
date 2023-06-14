package com.myfitnessapp.training.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class TrainingDto {
    @NotBlank
    @Length(min = 4)
    private String name;
    @NotBlank
    @Length(min = 4)
    private String category;
    @NotBlank
    @Length(min = 4)
    private String content;
    @NotBlank
    @Length(min = 4)
    private String level;
}
