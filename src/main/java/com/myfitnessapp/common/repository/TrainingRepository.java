package com.myfitnessapp.common.repository;

import com.myfitnessapp.common.model.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    Optional<Training> findBySlug(String slug);
    Page<Training> findByCategoryId(Long id, Pageable pageable);


}
