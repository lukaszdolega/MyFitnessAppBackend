package com.myfitnessapp.admin.training.repository;

import com.myfitnessapp.admin.training.model.AdminTraining;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminTrainingRepository extends JpaRepository<AdminTraining, Long> {
}
