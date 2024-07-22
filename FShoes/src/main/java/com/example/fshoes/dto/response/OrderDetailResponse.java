package com.example.fshoes.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    Long id;
    Long productDetailId;
    String productName;
    String colorName;
    String sizeName;
    String brandName;
    String categoryName;
    String fabricName;
    String soleName;
    Integer quantity;
    Double totalMoney;
}
