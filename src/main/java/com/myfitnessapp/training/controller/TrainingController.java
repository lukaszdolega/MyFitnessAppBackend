package com.myfitnessapp.training.controller;


import com.github.slugify.Slugify;
import com.myfitnessapp.training.controller.dto.TrainingDto;
import com.myfitnessapp.common.model.dto.TrainingListDto;
import com.myfitnessapp.common.model.Training;
import com.myfitnessapp.training.service.TrainingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/trainings")
    public Page<TrainingListDto> getTrainings(Pageable pageable) {
        Page<Training> trainings = trainingService.getTrainings(pageable);
        List<TrainingListDto> trainingListDtos = trainings.getContent().stream()
                .map(training -> TrainingListDto.builder()
                        .id(training.getId())
                        .name(training.getName())
                        .content(training.getContent())
                        .level(training.getLevel())
                        .slug(training.getSlug())
                        .build())
                .toList();
        return new PageImpl<>(trainingListDtos, pageable, trainings.getTotalElements());
    }

    @PostMapping("/trainings")
    public Training createTraining(@RequestBody @Valid TrainingDto trainingDto) {
        return trainingService.createTraining(Training.builder()
                        .name(trainingDto.getName())
                        .categoryId(trainingDto.getCategoryId())
                        .content(trainingDto.getContent())
                        .level(trainingDto.getLevel())
                        .slug(slugifySlug(trainingDto.getSlug()))
                .build());
    }

    @GetMapping("/trainings/{slug}")
    public TrainingDto getTrainingBySlug(
            @PathVariable
            @Pattern(regexp = "[a-z0-9\\-]+")
            @Length(max = 255)
            String slug) {
        return trainingService.getTrainingBySlug(slug);
    }

    private String slugifySlug(String slug) {
        Slugify slugify = new Slugify();
        return slugify.withCustomReplacement("_", "-")
                .slugify(slug);
    }
}
