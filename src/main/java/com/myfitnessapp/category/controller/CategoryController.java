package com.myfitnessapp.category.controller;

import com.myfitnessapp.category.dto.CategoryTrainingDto;
import com.myfitnessapp.category.service.CategoryService;
import com.myfitnessapp.common.model.Category;

import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Validated
public class CategoryController {

    public final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{slug}/trainings")
    public CategoryTrainingDto getCategoriesWithTrainings(@PathVariable
                                                         @Pattern(regexp = "[a-z0-9\\-]+")
                                                         @Length(max = 255) String slug, Pageable pageable) {
        return categoryService.getCategoriesWithTrainings(slug, pageable);
    }
}
