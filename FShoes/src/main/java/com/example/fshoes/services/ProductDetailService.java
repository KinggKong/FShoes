package com.example.fshoes.services;

import com.example.fshoes.dto.request.ProductDetailRequest;
import com.example.fshoes.dto.response.ProductDetailResponse;
import com.example.fshoes.entities.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductDetailService {
    Page<ProductDetailResponse> getAll(Pageable pageable);

    String add(ProductDetailRequest request);

    String update(ProductDetailRequest request, Long id);

    String delete(Long id);

    ProductDetail getProductDetailById(Long id);

    void updateQuantityProductDetail(Long id,Integer quantity,String action);

    boolean exists(Long id);
}
