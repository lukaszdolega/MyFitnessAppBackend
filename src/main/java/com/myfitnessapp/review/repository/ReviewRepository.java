package com.myfitnessapp.review.repository;

import com.myfitnessapp.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
