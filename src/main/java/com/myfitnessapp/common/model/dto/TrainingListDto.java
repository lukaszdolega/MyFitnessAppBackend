package com.myfitnessapp.common.model.dto;


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
