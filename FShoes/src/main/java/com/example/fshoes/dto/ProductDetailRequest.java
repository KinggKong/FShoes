package com.example.fshoes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailRequest {
    private Long sizeId;
    private Long colorId;
    private int quantity;
    private float salePrice;
    private String productCode;
    private String description;
    private String  src_img;
    private int status;
}
