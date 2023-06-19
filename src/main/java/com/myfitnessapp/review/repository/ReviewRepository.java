package com.myfitnessapp.review.repository;

import com.myfitnessapp.common.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
