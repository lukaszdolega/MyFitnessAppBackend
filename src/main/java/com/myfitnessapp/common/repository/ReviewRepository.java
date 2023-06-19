package com.myfitnessapp.common.repository;

import com.myfitnessapp.common.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByTrainingIdAndModerated(Long trainingId, boolean moderated);
}
