package com.myfitnessapp.admin.controller;

import com.myfitnessapp.admin.model.AdminTraining;
import com.myfitnessapp.admin.service.AdminTrainingService;
import com.myfitnessapp.training.model.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminTrainingController {

    private final AdminTrainingService trainingService;

    @GetMapping("/admin/trainings")
    public Page<AdminTraining> getTrainings(Pageable pageable) {
        return trainingService.getTrainings(pageable);
    }
}
