package com.example.fshoes.repositories;

import com.example.fshoes.entities.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetail, Long> {
}
