package com.example.fshoes.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponse {
    private Long id;
    private String colorName;
    private String productName;
    private String sizeName;
    private String brandName;
    private String categoryName;
    private String fabricName;
    private String soleName;
    private String productCode;
    private String description;
    private Double price;
    private Integer quantity;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Integer status;
}
