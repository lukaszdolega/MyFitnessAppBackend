package com.myfitnessapp.training.controller;


import com.myfitnessapp.admin.controller.dto.AdminTrainingDto;
import com.myfitnessapp.admin.model.AdminTraining;
import com.myfitnessapp.training.controller.dto.TrainingDto;
import com.myfitnessapp.training.model.Training;
import com.myfitnessapp.training.service.TrainingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
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
                        .category(trainingDto.getCategory())
                        .content(trainingDto.getContent())
                        .level(trainingDto.getLevel())
                .build());
    }
}
