package com.myfitnessapp.review.controller;

import com.myfitnessapp.review.controller.dto.ReviewDto;
import com.myfitnessapp.common.model.Review;
import com.myfitnessapp.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public Review addReview(@RequestBody @Valid ReviewDto reviewDto) {
        return reviewService.addReview(Review.builder()
                .authorName(cleanContent(reviewDto.authorName()))
                .content(cleanContent(reviewDto.content()))
                .trainingId(reviewDto.trainingId())
                .build());
    }

    private String cleanContent(String text) {
        return Jsoup.clean(text, Safelist.none());
    }
}