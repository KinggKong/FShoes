package com.example.fshoes.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductDetailRequest {
    Long productId;
    Long sizeId;
    Long colorId;
    Long brandId;
    Long soleId;
    Long fabricId;
    Long categoryId;
    Integer quantity;
    Double price;
    String description;
    Integer status;

}
