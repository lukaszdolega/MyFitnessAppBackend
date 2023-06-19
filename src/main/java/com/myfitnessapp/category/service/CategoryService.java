package com.myfitnessapp.category.service;

import com.myfitnessapp.category.model.Category;
import com.myfitnessapp.category.model.CategoryTrainingDto;
import com.myfitnessapp.category.repository.CategoryRepository;
import com.myfitnessapp.training.controller.dto.TrainingListDto;
import com.myfitnessapp.training.model.Training;
import com.myfitnessapp.training.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final TrainingRepository trainingRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CategoryTrainingDto getCategoriesWithTrainings(String slug, Pageable pageable) {
        Category category = categoryRepository.findBySlug(slug);
        Page<Training> page = trainingRepository.findByCategoryId(category.getId(), pageable);
        List<TrainingListDto> trainingListDtos = page.getContent().stream()
                .map(training -> TrainingListDto.builder()
                        .id(training.getId())
                        .name(training.getName())
                        .content(training.getContent())
                        .level(training.getLevel())
                        .slug(training.getSlug())
                        .build())
                .toList();
        return new CategoryTrainingDto(category, new PageImpl<>(trainingListDtos, pageable, page.getTotalElements()));
    }
}