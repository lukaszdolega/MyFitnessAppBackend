package com.myfitnessapp.training.service;

import com.myfitnessapp.common.model.Review;
import com.myfitnessapp.common.model.Training;
import com.myfitnessapp.common.repository.ReviewRepository;
import com.myfitnessapp.common.repository.TrainingRepository;
import com.myfitnessapp.training.controller.dto.TrainingDto;
import com.myfitnessapp.training.service.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final ReviewRepository reviewRepository;

    public Page<Training> getTrainings(Pageable pageable) {
        return trainingRepository.findAll(pageable);
    }

    public Training createTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Transactional(readOnly = true)
    public TrainingDto getTrainingBySlug(String slug) {
        Training training = trainingRepository.findBySlug(slug).orElseThrow();
        List<Review> reviews = reviewRepository.findAllByTrainingIdAndModerated(training.getId(), true);
        return mapToProductDto(training, reviews);
    }

    private TrainingDto mapToProductDto(Training training, List<Review> reviews) {
        return TrainingDto.builder()
                .id(training.getId())
                .name(training.getName())
                .categoryId(training.getCategoryId())
                .content(training.getContent())
                .level(training.getLevel())
                .slug(training.getSlug())
                .reviews(reviews.stream().map(review -> ReviewDto.builder()
                        .id(review.getId())
                        .trainingId(review.getTrainingId())
                        .authorName(review.getAuthorName())
                        .content(review.getContent())
                        .moderate(review.isModerated())
                        .build()
                ).toList())
                .build();
    }
}
