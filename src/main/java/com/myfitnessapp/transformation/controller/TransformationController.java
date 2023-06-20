package com.myfitnessapp.transformation.controller;

import com.myfitnessapp.common.model.Training;
import com.myfitnessapp.common.model.dto.TrainingListDto;
import com.myfitnessapp.training.service.TrainingService;
import com.myfitnessapp.transformation.controller.dto.TransformationDto;
import com.myfitnessapp.transformation.model.Transformation;
import com.myfitnessapp.transformation.service.TransformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransformationController {
    private final TransformationService transformationService;

    @GetMapping("/transformations")
    public Page<Transformation> getTransformations(Pageable pageable) {
        return transformationService.getTransformations(pageable);
    }
}
