package com.francis.sneaker_api.controller;

import com.francis.sneaker_api.dto.CreateSaleRequest;
import com.francis.sneaker_api.dto.SaleResponse;
import com.francis.sneaker_api.service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponse> createSale(@Valid @RequestBody CreateSaleRequest request) {
        return ResponseEntity.ok(saleService.createSale(request));
    }

    @GetMapping
    public List<SaleResponse> getAllSales() {
        return saleService.getAllSales();
    }
}
