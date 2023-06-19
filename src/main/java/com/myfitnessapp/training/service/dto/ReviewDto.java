package com.myfitnessapp.training.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewDto {
    private Long id;
    private Long trainingId;
    private String authorName;
    private String content;
    private boolean moderate;
}