package com.myfitnessapp.transformation.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransformationDto {
    private int weightBefore;
    private int weightAfter;
    private String imageBefore;
    private String imageAfter;
    private int duration;
}
