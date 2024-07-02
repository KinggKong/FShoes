package com.example.fshoes.services.impl;


import com.example.fshoes.entities.Product;
import com.example.fshoes.entities.Size;
import com.example.fshoes.repositories.ProductRepo;
import com.example.fshoes.services.IProductService;
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

public class ProductService implements IProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getProduct() {
        return productRepo.findAll();
    }

    @Override
    public Page<Product> pagination(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public void addProduct(String productName) {
        Product product = new Product();
        product.setProductName(productName);
        product.setStatus(1);
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
}
