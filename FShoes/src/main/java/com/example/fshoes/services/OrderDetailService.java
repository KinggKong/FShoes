package com.example.fshoes.services;

import com.example.fshoes.dto.request.OrderDetailRequest;
import com.example.fshoes.dto.response.OrderDetailResponse;
import com.example.fshoes.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetailRequest request);
    List<OrderDetailResponse> findAllByOrderId(Long orderId);
    String update(OrderDetailRequest orderDetailRequest, Long id);
}

