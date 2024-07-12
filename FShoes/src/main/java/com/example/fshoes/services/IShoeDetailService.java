package com.example.fshoes.services;

import com.example.fshoes.entities.ProductDetail;

import java.util.List;

public interface IShoeDetailService {
    List<ProductDetail> getShoeDetails();

    List<ProductDetail> filterShoeDetails(Long brandId, Long categoryId, Long fabricId, Long soleId, Long colorId, Long sizeId);

    void deleteShoeDetails(Long shoeId);
}
