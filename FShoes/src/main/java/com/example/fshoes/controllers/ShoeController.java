package com.example.fshoes.controllers;

import com.example.fshoes.dto.ProductRequest;
import com.example.fshoes.entities.Product;
import com.example.fshoes.services.impl.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoes")
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class ShoeController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("product", new Product());

        return "home/shoe";
    }
    @PostMapping("/")
    public ResponseEntity<Product> addProductWithDetails(@RequestBody ProductRequest productRequest) {
        Product createdProduct = productService.addProductWithDetails(productRequest);
        return ResponseEntity.ok(createdProduct);
    }

}
