package com.BookStore.demo.services;

import com.BookStore.demo.controllers.BooksController;
import com.BookStore.demo.models.Books;
import com.BookStore.demo.models.Category;
import com.BookStore.demo.repositories.BooksRepo;
import com.BookStore.demo.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BooksService {

    @Autowired
    private BooksRepo booksRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public void createBook(Long categoryId, Books book){
        categoryRepo.findById(categoryId).map(category ->{
            book.setCategory(category);
            return booksRepo.save(book);
        });
    }
    public Iterable<Books> getAllBooks() {
        return booksRepo.findAll();
    }

    public ResponseEntity<?> getBookById(Long bookId) {
        Books b = booksRepo.findById(bookId).orElse(null);
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
    public void updateBookById(Long categoryId, Books book) {
        categoryRepo.findById(categoryId).map(category -> {
            book.setCategory(category);
            return booksRepo.save(book);
        });
    }
    public void deleteBook(Long bookId){
       booksRepo.deleteById(bookId);

    }

    public Iterable<Books> findByCategoryId(Long categoryId){
      return booksRepo.findByCategoryId(categoryId);
    }

    public Iterable<Books> searchForBookByName(String search){
        return booksRepo.searchForBooksByName(search);
    }


}
