package com.myfitnessapp.training.repository;

import com.myfitnessapp.training.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
