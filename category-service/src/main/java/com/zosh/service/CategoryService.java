package com.zosh.service;


import com.zosh.dto.SalonDTO;
import com.zosh.entity.Category;

import java.util.Set;


public interface CategoryService {
    Category createCategory(Category category, SalonDTO salon);
    Set<Category> getAllCategoryBySalon(Long id);
    Category getCategoryById(Long id);
    void deleteCategory(Long id);
}
