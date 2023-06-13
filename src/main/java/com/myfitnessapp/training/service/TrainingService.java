package com.myfitnessapp.training.service;

import com.myfitnessapp.training.model.Training;
import com.myfitnessapp.training.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public List<Training> getTrainings(){
        return trainingRepository.findAll();
    }
}
