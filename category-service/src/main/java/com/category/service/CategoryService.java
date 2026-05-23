package com.category.service;


import com.category.dto.SalonDTO;
import com.category.entity.Category;

import java.util.Set;


public interface CategoryService {
    Category createCategory(Category category, SalonDTO salon);
    Set<Category> getAllCategoryBySalon(Long id);
    Category getCategoryById(Long id);
    void deleteCategory(Long id,Long SalonId);
}
