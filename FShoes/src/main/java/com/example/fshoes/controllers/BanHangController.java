package com.example.fshoes.controllers;


import com.example.fshoes.entities.Product;
import com.example.fshoes.entities.ProductDetail;
import com.example.fshoes.services.impl.ProductDetailService;
import com.example.fshoes.services.impl.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/banHang")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BanHangController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;


    @GetMapping("/")
    public String showSPCT(Model model){
        List<Product> products = productService.getProduct();
        List<ProductDetail> productDetails = productDetailService.getProductDetail();

        model.addAttribute("products", products);
        model.addAttribute("productDetails", productDetails);

        return "home/banHang";
    }

}
