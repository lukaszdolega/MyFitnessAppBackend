package com.myfitnessapp.training.controller;


import com.myfitnessapp.training.controller.dto.TrainingDto;
import com.myfitnessapp.training.model.Training;
import com.myfitnessapp.training.service.TrainingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/trainings")
    public Page<Training> getTrainings(Pageable pageable) {
        return trainingService.getTrainings(pageable);
    }

    @PostMapping("/trainings")
    public Training createTraining(@RequestBody @Valid TrainingDto trainingDto) {
        return trainingService.createTraining(Training.builder()
                        .name(trainingDto.getName())
                        .categoryId(trainingDto.getCategoryId())
                        .content(trainingDto.getContent())
                        .level(trainingDto.getLevel())
                .build());
    }

    @GetMapping("/trainings/{slug}")
    public Training getTrainingBySlug(
            @PathVariable
            @Pattern(regexp = "[a-z0-9\\-]+")
            @Length(max = 255)
            String slug) {
        return trainingService.getTrainingBySlug(slug);
    }
}
