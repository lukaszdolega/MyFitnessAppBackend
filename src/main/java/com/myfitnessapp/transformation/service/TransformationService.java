package com.myfitnessapp.transformation.service;

import com.myfitnessapp.transformation.model.Transformation;
import com.myfitnessapp.transformation.repository.TransformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransformationService {
    private final TransformationRepository transformationRepository;

    public Page<Transformation> getTransformations(Pageable pageable) {
       return transformationRepository.findAll(pageable);
    }

    public Transformation getTransformation(Long id) {
        return transformationRepository.findById(id).orElseThrow();
    }

    public Transformation createTransformation(Transformation transformation) {
        return transformationRepository.save(transformation);
    }
}
