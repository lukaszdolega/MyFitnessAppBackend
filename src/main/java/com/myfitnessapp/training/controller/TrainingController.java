package com.myfitnessapp.training.controller;


import com.myfitnessapp.training.model.Training;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingController {

    @GetMapping("/trainings")
    public List<Training> getTrainings() {
        return List.of(
                new Training("trening 1", "content 1" ,"category 1", "lvl 1"),
                new Training("trening 2", "content 2" ,"category 2", "lvl 2"),
                new Training("trening 3", "content 3" ,"category 3", "lvl 3"),
                new Training("trening 4", "content 4" ,"category 4", "lvl 4")
        );
    }
}
