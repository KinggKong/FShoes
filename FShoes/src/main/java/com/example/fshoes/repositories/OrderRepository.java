package com.example.fshoes.repositories;

import com.example.fshoes.entities.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.status=0")
    List<Order> listHoaDonCho();


    @Query("select o from Order o where o.id=:orderId")
    Order getById(@Param("orderId") Long orderId);

    @Transactional
    @Query("delete from Order where status=0")
    void deleteAll();

    @Query(value ="Update Order SET status=1 where id=:id)",nativeQuery = true)
    Order thanhToan(@Param("id")Long id);

}
