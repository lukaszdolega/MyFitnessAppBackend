package com.myfitnessapp.admin.service;

import com.myfitnessapp.admin.model.AdminTraining;
import com.myfitnessapp.admin.repository.AdminTrainingRepository;
import com.myfitnessapp.training.model.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminTrainingService {

    private final AdminTrainingRepository trainingRepository;

    public Page<AdminTraining> getTrainings(Pageable pageable){
        return trainingRepository.findAll(pageable);
    }
}
