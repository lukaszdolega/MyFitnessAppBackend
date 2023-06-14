package com.myfitnessapp.admin.controller.dto;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AdminTrainingDto {
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
    @NotBlank
    @Length(min = 4)
    private String slug;
}
