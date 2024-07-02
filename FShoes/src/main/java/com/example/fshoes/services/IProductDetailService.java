package com.example.fshoes.services;

import com.example.fshoes.entities.Product;
import com.example.fshoes.entities.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductDetailService {

    List<ProductDetail> getProductDetail();

    Page<ProductDetail> pagination(Pageable pageable);

    void addProductDetail(String productDetailName);

    void deleteProductDetail(Long id);

    void updateProductDetail(ProductDetail productDetail);

    ProductDetail findProductById(Long id);
}
