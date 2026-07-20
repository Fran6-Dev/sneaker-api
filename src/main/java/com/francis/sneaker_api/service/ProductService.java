package com.francis.sneaker_api.service;

import com.francis.sneaker_api.dto.CreateProductRequest;
import com.francis.sneaker_api.dto.ProductResponse;
import com.francis.sneaker_api.exception.ProductNotFoundException;
import com.francis.sneaker_api.model.Category;
import com.francis.sneaker_api.model.Product;
import com.francis.sneaker_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getSize(),
                product.getStock(),
                product.getDescription(),
                product.getCategory()
        );
    }

    private Product toEntity(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setBrand(request.getBrand());
        product.setPrice(request.getPrice());
        product.setSize(request.getSize());
        product.setStock(request.getStock());
        product.setDescription(request.getDescription());
        product.setCategory(request.getCategory());
        return product;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<ProductResponse> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return toResponse(product);
    }

    public ProductResponse createProduct(CreateProductRequest request) {
        return toResponse(productRepository.save(toEntity(request)));
    }

    public ProductResponse updateProduct(Long id, CreateProductRequest request) {
        return productRepository.findById(id).map(product -> {
            product.setName(request.getName());
            product.setBrand(request.getBrand());
            product.setPrice(request.getPrice());
            product.setSize(request.getSize());
            product.setStock(request.getStock());
            product.setDescription(request.getDescription());
            return toResponse(productRepository.save(product));
        }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
