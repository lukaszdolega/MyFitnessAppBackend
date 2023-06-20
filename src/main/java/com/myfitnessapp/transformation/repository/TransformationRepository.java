package com.myfitnessapp.transformation.repository;

import com.myfitnessapp.transformation.model.Transformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransformationRepository extends JpaRepository<Transformation, Long> {
}
