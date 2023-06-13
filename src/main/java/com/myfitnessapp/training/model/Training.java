package com.myfitnessapp.training.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Training {
    private String name;
    private String content;
    private String category;
    private String level;

}
