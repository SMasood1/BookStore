package com.BookStore.demo.controllers;

import com.BookStore.demo.models.Books;
import com.BookStore.demo.models.Category;
import com.BookStore.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/books/{categoryId}/books")
    public void createBook(@PathVariable Long categoryId, @RequestBody Books book){
        booksService.createBook(categoryId,book);
    }

    @GetMapping("/books")
    public Iterable<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PutMapping("/books/{categoryId}/books")
    public void updateBook(@PathVariable Long categoryId,@RequestBody Books book) {
        booksService.updateBookById(categoryId,book);
    }
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
         booksService.deleteBook(bookId);
    }

    @GetMapping("/books/{categoryId}/books")
    public Iterable<Books> getAllBooksInCategory(@PathVariable Long categoryId) {
        return booksService.findByCategoryId(categoryId);
    }

    @GetMapping("/searchBooks")
    public Iterable<Books> searchForBookByName(@RequestParam("search") String search){
        return booksService.searchForBookByName(search);
    }
    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId){
        return booksService.getBookById(bookId);
    }


}
