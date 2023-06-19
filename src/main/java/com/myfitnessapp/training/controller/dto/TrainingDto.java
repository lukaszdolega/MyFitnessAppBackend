package com.myfitnessapp.training.controller.dto;


import com.myfitnessapp.training.service.dto.ReviewDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Builder
public class TrainingDto {
    private Long id;
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
    private List<ReviewDto> reviews;
}
