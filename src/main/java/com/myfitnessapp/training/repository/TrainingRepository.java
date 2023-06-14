package com.myfitnessapp.training.repository;

import com.myfitnessapp.training.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    Optional<Training> findBySlug(String slug);
}
