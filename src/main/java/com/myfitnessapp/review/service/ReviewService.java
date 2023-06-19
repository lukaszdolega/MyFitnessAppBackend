package com.myfitnessapp.review.service;

import com.myfitnessapp.common.model.Review;
import com.myfitnessapp.common.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Review addReview(Review review){
        return reviewRepository.save(review);
    }
}