package com.myfitnessapp.admin.controller;

import com.myfitnessapp.admin.controller.dto.AdminTrainingDto;
import com.myfitnessapp.admin.model.AdminTraining;
import com.myfitnessapp.admin.service.AdminTrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public AdminTraining createTraining(@RequestBody AdminTrainingDto adminTrainingDto) {
        return trainingService.createTraining(mapAdminTraining(adminTrainingDto, EMPTY_ID));
    }

    @PutMapping("/admin/trainings/{id}")
    public AdminTraining updateTraining(@RequestBody AdminTrainingDto adminTrainingDto, @PathVariable Long id){
        return trainingService.updateTraining(mapAdminTraining(adminTrainingDto, id));
    }

    private static AdminTraining mapAdminTraining(AdminTrainingDto adminTrainingDto, Long id) {
        return AdminTraining.builder()
                .id(id)
                .name(adminTrainingDto.getName())
                .category(adminTrainingDto.getCategory())
                .content(adminTrainingDto.getContent())
                .level(adminTrainingDto.getLevel())
                .build();
    }
}
