package com.myfitnessapp.training.controller;


import com.myfitnessapp.training.model.Training;
import com.myfitnessapp.training.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/trainings")
    public Page<Training> getTrainings(Pageable pageable) {
        return trainingService.getTrainings(pageable);
    }
}
