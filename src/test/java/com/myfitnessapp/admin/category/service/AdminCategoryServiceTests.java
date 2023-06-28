package com.myfitnessapp.admin.category.service;

import com.myfitnessapp.admin.category.controller.dto.AdminCategoryDto;
import com.myfitnessapp.admin.category.model.AdminCategory;
import com.myfitnessapp.admin.category.repository.AdminCategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class AdminCategoryServiceTests {

    @Mock
    private AdminCategoryRepository adminCategoryRepository;

    @InjectMocks
    private AdminCategoryService adminCategoryService;

    @Test
    public void testGetCategories() {
        // Given
        List<AdminCategory> expectedCategories = Arrays.asList(
                new AdminCategory(1L, "Category 1", "Description 1", "category-1"),
                new AdminCategory(2L, "Category 2", "Description 2", "category-2")
        );
        when(adminCategoryRepository.findAll()).thenReturn(expectedCategories);

        // When
        List<AdminCategory> actualCategories = adminCategoryService.getCategories();

        // Then
        assertThat(actualCategories).isEqualTo(expectedCategories);
        verify(adminCategoryRepository, times(1)).findAll();
    }

    @Test
    public void testGetCategory() {
        // Given
        Long categoryId = 1L;
        AdminCategory expectedCategory = new AdminCategory(categoryId, "Category 1", "Description 1", "category-1");
        when(adminCategoryRepository.findById(categoryId)).thenReturn(Optional.of(expectedCategory));

        // When
        AdminCategory actualCategory = adminCategoryService.getCategory(categoryId);

        // Then
        assertThat(actualCategory).isEqualTo(expectedCategory);
        verify(adminCategoryRepository, times(1)).findById(categoryId);
    }

    @Test
    public void testCreateCategory() {
        // Given
        AdminCategoryDto adminCategoryDto = new AdminCategoryDto();
        adminCategoryDto.setName("Category 1");
        adminCategoryDto.setDescription("Description 1");
        adminCategoryDto.setSlug("category-1");

        AdminCategory mappedCategory = new AdminCategory(null, "Category 1", "Description 1", "category-1");
        AdminCategory createdCategory = new AdminCategory(1L, "Category 1", "Description 1", "category-1");
        when(adminCategoryRepository.save(mappedCategory)).thenReturn(createdCategory);

        // When
        AdminCategory actualCategory = adminCategoryService.createCategory(mappedCategory);

        // Then
        assertThat(actualCategory).isEqualTo(createdCategory);
        verify(adminCategoryRepository, times(1)).save(mappedCategory);
    }

    @Test
    public void testUpdateCategory() {
        // Given
        Long categoryId = 1L;
        AdminCategoryDto adminCategoryDto = new AdminCategoryDto();
        adminCategoryDto.setName("Updated Category");
        adminCategoryDto.setDescription("Updated Description");
        adminCategoryDto.setSlug("updated-category");

        AdminCategory mappedCategory = new AdminCategory(categoryId, adminCategoryDto.getName(), adminCategoryDto.getDescription(), adminCategoryDto.getSlug());
        AdminCategory updatedCategory = new AdminCategory(categoryId, adminCategoryDto.getName(), adminCategoryDto.getDescription(), adminCategoryDto.getSlug());
        when(adminCategoryRepository.save(mappedCategory)).thenReturn(updatedCategory);

        // When
        AdminCategory actualCategory = adminCategoryService.updateCategory(mappedCategory);

        // Then
        assertThat(actualCategory).isEqualTo(updatedCategory);
        verify(adminCategoryRepository, times(1)).save(mappedCategory);
    }

    @Test
    public void testDeleteCategory() {
        // Given
        Long categoryId = 1L;

        // When
        adminCategoryService.deleteCategory(categoryId);

        // Then
        verify(adminCategoryRepository, times(1)).deleteById(categoryId);
    }
}