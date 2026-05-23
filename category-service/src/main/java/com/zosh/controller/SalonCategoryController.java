package com.zosh.controller;

import com.zosh.dto.SalonDTO;
import com.zosh.entity.Category;
import com.zosh.service.CategoryService;
import com.zosh.service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {
    private final CategoryService categoryService;

    @Autowired
    public SalonCategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/api/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
//        we get the salonId later on by "KeyClock"
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);
        Category savedCategory = categoryService.createCategory(category,salonDTO);
        return new ResponseEntity<>(savedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id){
//      we get the salonId later on by "KeyClock"
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);
        categoryService.deleteCategory(id,salonDTO.getId());
        return new ResponseEntity<>("Deleted the category",HttpStatus.OK);
    }
}
