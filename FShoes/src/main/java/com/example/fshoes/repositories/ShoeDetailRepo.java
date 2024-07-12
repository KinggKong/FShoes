package com.example.fshoes.repositories;

import com.example.fshoes.entities.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoeDetailRepo extends JpaRepository<ProductDetail, Long> {

    @Query(value = "SELECT pdt.* FROM productdetail pdt \n" +
            "INNER JOIN product p ON p.id = pdt.product_id\n" +
            "WHERE (p.brand_id = '' OR p.brand_id = :brand_id or :brand_id is null) AND\n" +
            "      ( p.category_id = '' OR p.category_id = :category_id or :category_id is null) AND \n" +
            "      (p.fabric_id = '' OR  p.fabric_id = :fabric_id or :fabric_id is null) AND\n" +
            "      ( p.sole_id = '' OR p.sole_id = :sole_id or :sole_id is null) AND\n" +
            "      ( pdt.color_id = '' OR pdt.color_id = :color_id or :color_id is null) AND \n" +
            "      (pdt.size_id = '' OR pdt.size_id = :size_id or :size_id is null)", nativeQuery = true)
    List<ProductDetail> getAllByFilter(@Param("brand_id") Long brandId,
                                       @Param("category_id") Long categoryId,
                                       @Param("fabric_id") Long fabricId,
                                       @Param("sole_id") Long soleId,
                                       @Param("color_id") Long colorId,
                                       @Param("size_id") Long sizeId);


    boolean existsByColor_Id(Long colorId);

}
