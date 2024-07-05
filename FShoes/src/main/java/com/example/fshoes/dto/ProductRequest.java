package com.example.fshoes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String productName;
    private String description;
    private Long categoryId;
    private Long brandId;
    private Long materialId;
    private Long soleMaterialId;
    private int status;
    private List<ProductDetailRequest> details;
}
