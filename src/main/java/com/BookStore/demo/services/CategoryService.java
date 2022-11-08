package com.BookStore.demo.services;

import com.BookStore.demo.models.Category;
import com.BookStore.demo.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    public void verifyCategory(Long categoryId)  {
        Category category = categoryRepo.findById(categoryId).orElse(null);
    }

    //create category

    public ResponseEntity<?> createCategory(Category category) {
        category = categoryRepo.save(category);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCategoryUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{categoryId}")
                .buildAndExpand(category.getId())
                .toUri();
        responseHeaders.setLocation(newCategoryUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<Category>> getAllCategories() {
        Iterable<Category> getAllCategories = categoryRepo.findAll();
        return new ResponseEntity<>(categoryRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getCategory(Long categoryId) {
        verifyCategory(categoryId);
        Optional<Category> p = categoryRepo.findById(categoryId);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }
    public void updateCategory(Long categoryId, Category category) {
        verifyCategory(categoryId);
        categoryRepo.save(category);
    }

    public void deleteCategory(Long categoryId){

        categoryRepo.deleteById(categoryId);

    }



}
