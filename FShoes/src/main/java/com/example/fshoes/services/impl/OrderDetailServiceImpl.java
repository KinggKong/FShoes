package com.example.fshoes.services.impl;

import com.example.fshoes.dto.request.OrderDetailRequest;
import com.example.fshoes.dto.response.OrderDetailResponse;
import com.example.fshoes.entities.Order;
import com.example.fshoes.entities.OrderDetail;
import com.example.fshoes.entities.ProductDetail;
import com.example.fshoes.repositories.OrderDetailRepository;
import com.example.fshoes.repositories.OrderRepository;
import com.example.fshoes.repositories.ProductDetailRepository;
import com.example.fshoes.services.OrderDetailService;
import com.example.fshoes.services.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductDetailService productDetailService;

    @Override
    public OrderDetail createOrderDetail(OrderDetailRequest request) {
        Order order = orderRepository.findById(request.getOrderId()).orElse(null);
        ProductDetail productDetail = productDetailRepository.findById(request.getProductDetailId()).get();
        Integer quantity = productDetail.getQuantity();
        if (quantity > productDetail.getQuantity()) {
            throw new RuntimeException("So luong trong kho k du");
        } else if (quantity == null) {
            throw new RuntimeException("Vui long nhap so luong");
        } else if (quantity < 0) {
            throw new RuntimeException("Vui long nhap so luong lon hon 0");
        }
        OrderDetail orderDetail = OrderDetail.builder()
                .order(order)
                .productDetail(productDetail)
                .quantity(1)
                .total_money(productDetail.getPrice() * quantity)
                .price(productDetail.getPrice())
                .build();
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetailResponse> findAllByOrderId(Long orderId) {
        return orderDetailRepository.findAllByOrderId(orderId);
    }

    @Override
    public String update(OrderDetailRequest orderDetailRequest, Long id) {
        Order order = orderRepository.findById(orderDetailRequest.getOrderId()).orElse(null);
        ProductDetail productDetail = productDetailRepository.findById(orderDetailRequest.getProductDetailId()).get();
        OrderDetail orderDetail = orderDetailRepository.findById(id).get();
        Integer quantity = 0;
        if (orderDetailRequest.getMethod().equalsIgnoreCase("plus")) {
            if (orderDetailRequest.getQuantity() > productDetail.getQuantity()) {
                throw new RuntimeException("So luong trong kho k du");
            }
            quantity = orderDetailRequest.getQuantity() + productDetail.getQuantity();
        } else {
            quantity = orderDetail.getQuantity() - orderDetailRequest.getQuantity();
        }
        orderDetail.setQuantity(quantity);
        orderDetail.setTotal_money(productDetail.getPrice() * quantity);
        orderDetailRepository.save(orderDetail);
        updateOrder(order.getId());
        if (orderDetailRequest.getMethod().equalsIgnoreCase("minus")) {
            productDetailService.updateQuantityProductDetail(productDetail.getId(), 1, "plus");
        } else {
            productDetailService.updateQuantityProductDetail(productDetail.getId(), 1, "minus");
        }
        return "Sua thanh cong";
    }

    public void updateOrder(Long id) {
        Double totalMoney = 0.0;
        Integer quantity = 0;
        Order order = orderRepository.findById(id).get();
        List<OrderDetailResponse> orderDetailResponseList = findAllByOrderId(id);
        for (OrderDetailResponse orderDetailResponse : orderDetailResponseList) {
            quantity += orderDetailResponse.getQuantity();
            totalMoney += orderDetailResponse.getTotalMoney();
        }

    }
}
