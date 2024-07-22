package com.example.fshoes.services.impl;

import com.example.fshoes.dto.request.OrderRequest;
import com.example.fshoes.dto.response.OrderResponse;
import com.example.fshoes.entities.Order;
import com.example.fshoes.repositories.KhachHangRepository;
import com.example.fshoes.repositories.OrderRepository;
import com.example.fshoes.repositories.ProductDetailRepository;
import com.example.fshoes.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final KhachHangRepository khachHangRepository;
    private final ProductDetailRepository productDetailRepository;
    @Override
    public List<OrderResponse> getAllOrder() {
        return List.of();
    }

    @Override
    public List<Order> listOrder() {
        return orderRepository.findAll();
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        return null;
    }

    // Phương thức tạo đơn hàng
    public void createOrder() {
        Order order = new Order();
        order.setCreated_at(LocalDateTime.now());
        order.setStatus(0);
        orderRepository.save(order);
    }


    @Override
    public void updateTrangThai(Long idHd) {
        Order order=orderRepository.getById(idHd);
        order.setStatus(1);
        orderRepository.save(order);
    }

    @Override
    public void cleanOrder() {
        orderRepository.deleteAll();
    }

    @Override
    public void updateOrder(OrderRequest request, String orderId) {

    }

    @Override
    public Order getById(Long orderId) {
        return orderRepository.getById(orderId);
    }

    @Override
    public void create(OrderRequest orderRequest) {
        Order order=Order.builder()
                .consignee_name(orderRequest.getTen_nguoi_nhan())
                .address(orderRequest.getDia_chi_nhan())
                .phone(orderRequest.getSdt())
                .created_at(LocalDateTime.now())
                .status(0)
                .build();
        orderRepository.save(order);
    }
}
