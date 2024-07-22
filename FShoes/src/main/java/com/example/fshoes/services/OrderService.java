package com.example.fshoes.services;

import com.example.fshoes.dto.request.OrderRequest;
import com.example.fshoes.dto.response.OrderResponse;
import com.example.fshoes.entities.Order;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAllOrder();
    List<Order> listOrder();
    OrderResponse getOrderById(Long id);
    void createOrder();
    void updateTrangThai(Long idHd);
    void cleanOrder();
    void updateOrder(OrderRequest request,String orderId);
    Order getById(Long orderId);

    void create(OrderRequest orderRequest);
}
