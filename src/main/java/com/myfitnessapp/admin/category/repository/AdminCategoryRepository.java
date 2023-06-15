package com.myfitnessapp.admin.category.repository;

import com.myfitnessapp.admin.category.model.AdminCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminCategoryRepository extends JpaRepository<AdminCategory, Long> {
}
