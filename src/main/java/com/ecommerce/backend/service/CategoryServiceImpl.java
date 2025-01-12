package com.ecommerce.backend.service;

import com.ecommerce.backend.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();
    private Long nextCategoryId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextCategoryId++);
        categories.add(category);
        System.out.println("Category " + category.getCategoryName() + " added successfully");
    }
}
