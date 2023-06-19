package com.myfitnessapp.training.controller.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TrainingListDto {
        private Long id;
        private String name;
        private String content;
        private String level;
        private String slug;
}
