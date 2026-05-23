package com.category.controller;

import com.category.entity.Category;
import com.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/api/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
    }

    @GetMapping("/api/category/salonId/{salonId}")
    public ResponseEntity<Set<Category>> getCategoryBySalonId(@PathVariable Long salonId){
        return new ResponseEntity<>(categoryService.getAllCategoryBySalon(salonId),HttpStatus.OK);
    }

}
