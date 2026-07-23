package com.francis.sneaker_api.controller;

import com.francis.sneaker_api.dto.CreateProductRequest;
import com.francis.sneaker_api.dto.ProductResponse;
import com.francis.sneaker_api.model.Category;
import com.francis.sneaker_api.model.Product;
import com.francis.sneaker_api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List ;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class ProductController {
    private final ProductService productService;

    @GetMapping("/brands")
    public List<String> getAllBrands() {
        return productService.getAllBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) String brand) {

        if (category != null && brand != null) {
            return productService.getProductsByCategoryAndBrand(category, brand);
        } else if (category != null) {
            return productService.getProductsByCategory(category);
        } else if (brand != null) {
            return productService.getProductsByBrand(brand);
        }
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @Valid @RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
