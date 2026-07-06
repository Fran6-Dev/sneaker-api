package com.francis.sneaker_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateSaleRequest {
    @NotNull(message = "Le produit est obligatoire")
    private Long productId;

    @NotNull(message = "Le produit est obligatoire")
    @Min(value = 1, message = "La quantité doit être au moins 1")
    private Integer quantity;

}
