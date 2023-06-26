package com.myfitnessapp.training.controller.dto;


import com.myfitnessapp.training.service.dto.ReviewDto;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
