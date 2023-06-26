package com.myfitnessapp.transformation.controller;

import com.myfitnessapp.transformation.controller.dto.TransformationDto;
import com.myfitnessapp.transformation.controller.dto.UploadResponse;
import com.myfitnessapp.transformation.model.Transformation;
import com.myfitnessapp.transformation.service.ImageService;
import com.myfitnessapp.transformation.service.TransformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequiredArgsConstructor
public class TransformationController {

    private final ImageService imageService;
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
    public Transformation createTransformation(@RequestBody @Valid TransformationDto transformationDto) {
        return transformationService.createTransformation(mapTransformation(transformationDto));
    }

    @PostMapping("/transformations/upload-image")
    public UploadResponse uploadImage(@RequestParam("file") MultipartFile multipartFile){
        try(InputStream inputStream = multipartFile.getInputStream()) {
            String savedFileName = imageService.uploadImage(multipartFile.getOriginalFilename(), inputStream);
            return new UploadResponse(savedFileName);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }

    @GetMapping("/data/images/{filename}")
    public ResponseEntity<Resource> serveFiles(@PathVariable String filename) throws IOException {
        Resource file = imageService.serveFiles(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Path.of(filename)))
                .body(file);
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
