package com.myfitnessapp.category.repository;

import com.myfitnessapp.common.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findBySlug(String slug);
}
