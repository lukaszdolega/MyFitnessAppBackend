package com.myfitnessapp.admin.training.service;

import com.myfitnessapp.admin.training.model.AdminTraining;
import com.myfitnessapp.admin.training.repository.AdminTrainingRepository;
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

    public AdminTraining getTraining(Long id) {
        return trainingRepository.findById(id).orElseThrow();
    }

    public AdminTraining updateTraining(AdminTraining training ) {
        return trainingRepository.save(training);
    }

    public AdminTraining createTraining(AdminTraining training) {
        return trainingRepository.save(training);
    }

    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }
}
