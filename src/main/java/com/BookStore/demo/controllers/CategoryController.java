package com.BookStore.demo.controllers;

import com.BookStore.demo.models.Category;
import com.BookStore.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getSingleCategory(@PathVariable Long categoryId) {
        categoryService.verifyCategory(categoryId);
        return categoryService.getCategory(categoryId);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable Long categoryId,@RequestBody Category category) {

        categoryService.verifyCategory(categoryId);
        categoryService.updateCategory(categoryId,category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/category/{categoryid}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        categoryService.verifyCategory(categoryId);
        return categoryService.deleteCategory(categoryId);
    }

}
