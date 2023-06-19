package com.myfitnessapp.admin.review.service;

import com.myfitnessapp.admin.review.model.AdminReview;
import com.myfitnessapp.admin.review.repository.AdminReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminReviewService {

    private final AdminReviewRepository reviewRepository;

    public List<AdminReview> getReviews() {
        return reviewRepository.findAll();
    }

    @Transactional
    public void moderate(Long id) {
        reviewRepository.moderate(id);
    }

    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}