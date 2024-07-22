package com.example.fshoes.repositories;

import com.example.fshoes.dto.response.OrderDetailResponse;
import com.example.fshoes.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("""
                select o from OrderDetail o where o.order.id=:orderId
            """)
    List<OrderDetail> findByOrderId(@Param("orderId") Long orderId);

    @Query("""
    select new com.example.fshoes.dto.response.OrderDetailResponse(od.id,od.productDetail.id,
    pd.product.name,pd.color.name,pd.size.name,pd.brand.name,pd.category.name
    ,pd.fabric.name,pd.sole.name,od.quantity,od.total_money)
    from OrderDetail od join ProductDetail pd on od.productDetail.id=pd.id
    where od.order.id=:orderId
""")
    List<OrderDetailResponse> findAllByOrderId(@Param("orderId") Long orderId);
}
