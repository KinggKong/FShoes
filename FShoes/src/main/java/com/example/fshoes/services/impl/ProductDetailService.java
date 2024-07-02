package com.example.fshoes.services.impl;


import com.example.fshoes.entities.ProductDetail;
import com.example.fshoes.entities.Size;
import com.example.fshoes.repositories.ProductDetailRepo;
import com.example.fshoes.services.IProductDetailService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)

public class ProductDetailService implements IProductDetailService {

    @Autowired
    ProductDetailRepo productDetailRepo;

    @Override
    public List<ProductDetail> getProductDetail() {
        return productDetailRepo.findAll();
    }

    @Override
    public Page<ProductDetail> pagination(Pageable pageable) {
        return productDetailRepo.findAll(pageable);
    }

    @Override
    public void addProductDetail(String productDetailName) {
       return;
    }

    @Override
    public void deleteProductDetail(Long id) {

    }

    @Override
    public void updateProductDetail(ProductDetail productDetail) {

    }

    @Override
    public ProductDetail findProductById(Long id) {
        return null;
    }
}
