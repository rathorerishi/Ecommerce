package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {//used Interface instead of class to promote modularity and loose coupling in my code
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);

}
