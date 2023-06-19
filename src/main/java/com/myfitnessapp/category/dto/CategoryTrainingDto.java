package com.myfitnessapp.category.dto;

import com.myfitnessapp.common.model.Category;
import com.myfitnessapp.common.model.dto.TrainingListDto;
import org.springframework.data.domain.Page;

public record CategoryTrainingDto(Category category, Page<TrainingListDto> trainings) {
}
