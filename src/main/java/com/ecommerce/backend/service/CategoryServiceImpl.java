package com.ecommerce.backend.service;

import com.ecommerce.backend.model.Category;
import com.ecommerce.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
//    private List<Category> categories = new ArrayList<>();
//    private Long nextCategoryId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
//        return categories;
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextCategoryId++);
//        categories.add(category);
        categoryRepository.save(category);
        System.out.println("Category " + category.getCategoryName() + " added successfully");
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
        List<Category> categories = categoryRepository.findAll();

        Optional<Category> tempCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();

        if (tempCategory.isPresent()) {
            Category existingCategory = tempCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            //            return existingCategory;
            return categoryRepository.save(existingCategory);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
    }

    @Override
    public String deleteCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll();

        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));


//        categories.remove(category);
        categoryRepository.delete(category);
        return "Category with categoryId " + categoryId + " deleted successfully";
    }
}
