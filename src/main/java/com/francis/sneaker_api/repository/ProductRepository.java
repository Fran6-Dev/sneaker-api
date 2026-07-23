package com.francis.sneaker_api.repository;

import com.francis.sneaker_api.model.Category;
import com.francis.sneaker_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrand(String brand);
    List<Product> findByCategory(Category category);
    List<Product> findByCategoryAndBrand(Category category, String brand);

    @Query("SELECT DISTINCT p.brand FROM Product p ORDER BY p.brand")
    List<String> findAllBrands();

}
