package com.example.fshoes.controllers;

import com.example.fshoes.dto.request.OrderDetailRequest;
import com.example.fshoes.services.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("order-detail")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, OrderDetailRequest request) {
        orderDetailService.update(request,id);
        return "home/banHang";
    }
}
