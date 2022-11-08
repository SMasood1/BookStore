package com.BookStore.demo.repositories;

import com.BookStore.demo.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Long> {
}
