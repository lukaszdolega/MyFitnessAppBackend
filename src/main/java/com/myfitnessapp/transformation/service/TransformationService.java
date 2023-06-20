package com.myfitnessapp.transformation.service;

import com.myfitnessapp.transformation.model.Transformation;
import com.myfitnessapp.transformation.repository.TransformationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransformationService {
    private final TransformationRepository transformationRepository;

    public List<Transformation> getTransformations() {
       return transformationRepository.findAll();
    }
}
