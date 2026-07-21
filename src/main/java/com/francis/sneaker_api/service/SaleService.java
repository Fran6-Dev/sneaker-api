package com.francis.sneaker_api.service;

import com.francis.sneaker_api.dto.CreateSaleRequest;
import com.francis.sneaker_api.dto.SaleResponse;
import com.francis.sneaker_api.exception.ProductNotFoundException;
import com.francis.sneaker_api.model.Product;
import com.francis.sneaker_api.model.Sale;
import com.francis.sneaker_api.repository.ProductRepository;
import com.francis.sneaker_api.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    private SaleResponse toResponse(Sale sale) {
        return new SaleResponse(
                sale.getId(),
                sale.getProduct().getName(),
                sale.getProduct().getBrand(),
                sale.getQuantity(),
                sale.getSize(),
                sale.getPromotion(),
                sale.getTotalPrice(),
                sale.getSaleDate()
        );
    }

    public SaleResponse createSale(CreateSaleRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(request.getProductId()));

        if (product.getStock() < request.getQuantity()) {
            throw new IllegalArgumentException("Stock insuffisant. Stock disponible : " + product.getStock());
        }

        product.setStock(product.getStock() - request.getQuantity());
        productRepository.save(product);

        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setQuantity(request.getQuantity());
        sale.setSize(product.getSize());
        sale.setPromotion(request.getPromotion());
        sale.setTotalPrice((product.getPrice() * request.getQuantity()) * (1 - request.getPromotion() / 100.0));

        return toResponse(saleRepository.save(sale));
    }

    public List<SaleResponse> getAllSales() {
        return saleRepository.findAllByOrderBySaleDateDesc()
                .stream()
                .map(this::toResponse)
                .toList();
    }
}
