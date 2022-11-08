package com.BookStore.demo.repositories;

import com.BookStore.demo.models.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends CrudRepository<Books,Long> {


     Iterable<Books> findByCategoryId(Long categoryId);

     // Select * From books WHERE name LIKE '%java%';
     @Query(value = "Select * From books WHERE name LIKE CONCAT('%', :search, '%')", nativeQuery = true)
     Iterable<Books> searchForBooksByName(String search);
}
