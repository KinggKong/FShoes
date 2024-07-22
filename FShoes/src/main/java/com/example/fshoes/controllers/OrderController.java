package com.example.fshoes.controllers;

import com.example.fshoes.dto.request.OrderRequest;
import com.example.fshoes.dto.response.OrderResponse;
import com.example.fshoes.entities.Order;
import com.example.fshoes.repositories.OrderRepository;
import com.example.fshoes.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<?> index(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/success/{id}")
    @ResponseBody
    public ResponseEntity<?> success(@PathVariable Long id) {
        Order o=orderRepository.thanhToan(id);
        return ResponseEntity.ok(o);
    }

}
