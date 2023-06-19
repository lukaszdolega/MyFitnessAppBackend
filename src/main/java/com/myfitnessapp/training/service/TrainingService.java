package com.myfitnessapp.training.service;

import com.myfitnessapp.common.model.Training;
import com.myfitnessapp.common.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Training getTrainingBySlug(String slug) {
        return trainingRepository.findBySlug(slug).orElseThrow();
    }
}
