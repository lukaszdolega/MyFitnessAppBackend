package com.myfitnessapp.transformation.controller;

import com.myfitnessapp.transformation.controller.dto.TransformationDto;
import com.myfitnessapp.transformation.model.Transformation;
import com.myfitnessapp.transformation.service.TransformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class TransformationController {

    private final TransformationService transformationService;

    @GetMapping("/transformations")
    public Page<Transformation> getTransformations(Pageable pageable) {
        return transformationService.getTransformations(pageable);
    }

    @GetMapping("/transformations/{id}")
    public Transformation getTransformation(@PathVariable Long id) {
        return transformationService.getTransformation(id);
    }

    @PostMapping("/transformations")
    public Transformation createTransformation(@RequestBody TransformationDto transformationDto) {
        return transformationService.createTransformation(mapTransformation(transformationDto));
    }

    private Transformation mapTransformation(TransformationDto transformationDto) {
        return Transformation.builder()
                .weightBefore(transformationDto.getWeightBefore())
                .weightAfter(transformationDto.getWeightAfter())
                .imageBefore(transformationDto.getImageBefore())
                .imageAfter(transformationDto.getImageAfter())
                .duration(transformationDto.getDuration())
                .build();
    }
}
