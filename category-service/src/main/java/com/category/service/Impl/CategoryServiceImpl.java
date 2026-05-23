package com.category.service.Impl;

import com.category.dto.SalonDTO;
import com.category.entity.Category;
import com.category.repository.CategoryRepository;
import com.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category createCategory(Category category, SalonDTO salonDTO) {
         Category catg = new Category();
         catg.setSalonId(salonDTO.getId());
         catg.setName(category.name);
         catg.setImage(category.getImage());
         return categoryRepository.save(catg);
    }

    @Override
    public Set<Category> getAllCategoryBySalon(Long id) {
        Set<Category> set = categoryRepository.findBySalonId(id);
        return set;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("category with respective ID is not present"));
    }

    @Override
    public void deleteCategory(Long id,Long salonId) {
        Category category = getCategoryById(id);
        if(!category.getSalonId().equals(salonId)){
            throw new RuntimeException("you cannot delete the category, only owner of the salon can");
        }
        categoryRepository.deleteById(id);
        System.out.println("Category with Id deleted");
    }
}
