package com.example.fshoes.repositories;

import com.example.fshoes.dto.response.ProductDetailResponse;
import com.example.fshoes.entities.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    @Query("select new com.example.fshoes.dto.response.ProductDetailResponse(pd.id,pd.color.name," +
            "p.name,s.name,b.name,c.name,f.name,so.name,p.name,pd.description," +
            "pd.price,pd.quantity,pd.createdAt,pd.updatedAt,pd.status) from ProductDetail pd " +
            "join Color color on pd.color.id=color.id join Product p on pd.product.id=p." +
            "id join Size s on pd.size.id=s.id join Brand b on pd.brand.id=b.id join " +
            "Category  c on pd.category.id=c.id join Fabric f on pd.fabric.id=f.id join Sole so on pd.sole.id=so.id where pd.status=1 order by pd.id desc ")
    List<ProductDetailResponse> getAllProductDetail();
}
