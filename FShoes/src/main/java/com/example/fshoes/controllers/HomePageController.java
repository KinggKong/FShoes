package com.example.fshoes.controllers;

import com.example.fshoes.dto.request.OrderDetailRequest;
import com.example.fshoes.dto.request.OrderRequest;
import com.example.fshoes.entities.Customer;
import com.example.fshoes.repositories.KhachHangRepository;
import com.example.fshoes.repositories.OrderDetailRepository;
import com.example.fshoes.repositories.OrderRepository;
import com.example.fshoes.repositories.ProductDetailRepository;
import com.example.fshoes.services.KhachHangService;
import com.example.fshoes.services.OrderDetailService;
import com.example.fshoes.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/homepage")
@RequiredArgsConstructor
public class HomePageController {
    private final ProductDetailRepository productDetailRepository;
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final KhachHangService khachHangService;
    private final KhachHangRepository khachHangRepository;
    private final OrderDetailService orderDetailService;
    private final OrderDetailRepository orderDetailRepository;


    @GetMapping("/list")
    public String homepage(Model model) {
        model.addAttribute("productdetails", productDetailRepository.getAllProductDetail());
        model.addAttribute("orders", orderRepository.listHoaDonCho());
        model.addAttribute("khachHangs", khachHangService.getAllKhachHang());
        return "home/sale-counter";
    }

    @PostMapping("/createOrder")
    public String createOrder(OrderRequest orderRequest) {
        orderService.create(orderRequest);
        return "redirect:/homepage/list";
    }
    @GetMapping("/khach-hang/{id}")
    public String getKH(Model model, @PathVariable Long id) {
        model.addAttribute("productdetails", productDetailRepository.getAllProductDetail());
        model.addAttribute("orders", orderRepository.listHoaDonCho());
        model.addAttribute("khachHangs", khachHangService.getAllKhachHang());

        // Lấy thông tin khách hàng theo ID
        Customer khachHang = khachHangRepository.findById(id).get();
        model.addAttribute("KH", khachHang);
        model.addAttribute("orderDetail",orderDetailService.findAllByOrderId(id));

        return "home/sale-counter";
    }
    @GetMapping("/orderDetail/{orderId}")
    @ResponseBody
    public ResponseEntity<?> getOrderDetail(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderDetailService.findAllByOrderId(orderId));
    }
    @GetMapping("/delete-orderDetail/{id}")
    public String deleteOrderDetail(@PathVariable Long id) {
        orderDetailRepository.deleteById(id);
        return "redirect:/homepage/list";
    }
    @GetMapping("/order/{orderId}")
    @ResponseBody
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderRepository.findById(orderId));
    }
    @PostMapping("/createCartDetail")
    public String addCartDetail(OrderDetailRequest request) {
        orderDetailService.createOrderDetail(request);
        return "redirect:/homepage/list";
    }
    @PostMapping("/add-cartDetail")
    @ResponseBody
    public ResponseEntity<?> add(OrderDetailRequest request){
        return ResponseEntity.ok(orderDetailService.createOrderDetail(request));
    }
}
