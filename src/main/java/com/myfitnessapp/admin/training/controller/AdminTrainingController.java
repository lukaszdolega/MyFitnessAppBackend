package com.myfitnessapp.admin.training.controller;

import com.github.slugify.Slugify;
import com.myfitnessapp.admin.training.controller.dto.AdminTrainingDto;
import com.myfitnessapp.admin.training.model.AdminTraining;
import com.myfitnessapp.admin.training.service.AdminTrainingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminTrainingController {

    public static final Long EMPTY_ID = null;
    private final AdminTrainingService trainingService;

    @GetMapping("/admin/trainings")
    public Page<AdminTraining> getTrainings(Pageable pageable) {
        return trainingService.getTrainings(pageable);
    }

    @GetMapping("/admin/trainings/{id}")
    public AdminTraining getTraining(@PathVariable Long id) {
        return trainingService.getTraining(id);
    }

    @PostMapping("/admin/trainings")
    public AdminTraining createTraining(@RequestBody @Valid AdminTrainingDto adminTrainingDto) {
        return trainingService.createTraining(mapAdminTraining(adminTrainingDto, EMPTY_ID));
    }

    @PutMapping("/admin/trainings/{id}")
    public AdminTraining updateTraining(@RequestBody @Valid AdminTrainingDto adminTrainingDto, @PathVariable Long id){
        return trainingService.updateTraining(mapAdminTraining(adminTrainingDto, id));
    }

    @DeleteMapping("/admin/trainings/{id}")
    public void deleteTraining(@PathVariable Long id){
        trainingService.deleteTraining(id);
    }

    private AdminTraining mapAdminTraining(AdminTrainingDto adminTrainingDto, Long id) {
        return AdminTraining.builder()
                .id(id)
                .name(adminTrainingDto.getName())
                .categoryId(adminTrainingDto.getCategoryId())
                .content(adminTrainingDto.getContent())
                .level(adminTrainingDto.getLevel())
                .slug(slugifySlug(adminTrainingDto.getSlug()))
                .build();
    }

    private String slugifySlug(String slug) {
        Slugify slugify = new Slugify();
        return slugify.withCustomReplacement("_", "-")
                .slugify(slug);
    }
}
