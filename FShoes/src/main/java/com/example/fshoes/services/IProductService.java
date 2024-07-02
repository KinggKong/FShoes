package com.example.fshoes.services;

import com.example.fshoes.entities.Product;
import com.example.fshoes.entities.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> getProduct();

    Page<Product> pagination(Pageable pageable);

    void addProduct(String productName);

    void deleteProduct(Long id);

    void updateProduct(Product product);

    Product findProductById(Long id);
}