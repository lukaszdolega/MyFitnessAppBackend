package com.myfitnessapp.category.model;

import com.myfitnessapp.training.controller.dto.TrainingListDto;
import com.myfitnessapp.training.model.Training;
import org.springframework.data.domain.Page;

public record CategoryTrainingDto(Category category, Page<TrainingListDto> trainings) {
}