package com.myfitnessapp.transformation.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
@Builder
public class TransformationDto {
    @NotNull
    @Min(1)
    private int weightBefore;
    @NotNull
    @Min(1)
    private int weightAfter;
    private String imageBefore;
    private String imageAfter;
    @NotNull
    @Min(1)
    private int duration;
}
