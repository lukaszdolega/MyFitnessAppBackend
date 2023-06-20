package com.myfitnessapp.transformation.service;

import com.myfitnessapp.transformation.model.Transformation;
import com.myfitnessapp.transformation.repository.TransformationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransformationService {
    private final TransformationRepository transformationRepository;

    public Page<Transformation> getTransformations(Pageable pageable) {
       return transformationRepository.findAll(pageable);
    }
}
