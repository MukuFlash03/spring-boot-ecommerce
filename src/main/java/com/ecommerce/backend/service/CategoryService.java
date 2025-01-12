package com.ecommerce.backend.service;

import com.ecommerce.backend.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    Category updateCategory(Long categoryId, Category category);
    String deleteCategory(Long categoryId);
}
