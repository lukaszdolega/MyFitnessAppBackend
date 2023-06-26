package com.myfitnessapp.transformation.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
