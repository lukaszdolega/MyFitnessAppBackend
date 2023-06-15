package com.myfitnessapp.admin.training.controller.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AdminTrainingDto {
    @NotBlank
    @Length(min = 4)
    private String name;
    @NotNull
    private Long categoryId;
    @NotBlank
    @Length(min = 4)
    private String content;
    @NotBlank
    @Length(min = 4)
    private String level;
    @NotBlank
    @Length(min = 4)
    private String slug;
}
