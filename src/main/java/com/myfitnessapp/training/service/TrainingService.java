package com.myfitnessapp.training.service;

import com.myfitnessapp.admin.model.AdminTraining;
import com.myfitnessapp.training.model.Training;
import com.myfitnessapp.training.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public Page<Training> getTrainings(Pageable pageable){
        return trainingRepository.findAll(pageable);
    }

    public Training createTraining(Training training) {
        return trainingRepository.save(training);
    }
}
