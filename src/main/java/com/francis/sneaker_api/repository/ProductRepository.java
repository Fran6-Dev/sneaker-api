package com.francis.sneaker_api.repository;

import com.francis.sneaker_api.model.Category;
import com.francis.sneaker_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
