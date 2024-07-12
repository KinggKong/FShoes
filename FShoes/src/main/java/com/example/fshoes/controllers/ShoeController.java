package com.example.fshoes.controllers;

import com.example.fshoes.entities.Product;
import com.example.fshoes.entities.ProductDetail;
import com.example.fshoes.services.impl.ProductDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shoes")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ShoeController {
    ProductDetailService prodcutDetailService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("product", new Product());
        return "home/shoe";
    }

    @GetMapping("/filter-products")
    @ResponseBody
    public ResponseEntity<List<ProductDetail>> filterProducts(
            @RequestParam(name = "brandId", defaultValue = "") Long brandId,
            @RequestParam(name = "categoryId", defaultValue = "") Long categoryId,
            @RequestParam(name = "fabricTypeId", defaultValue = "") Long fabricTypeId,
            @RequestParam(name = "soleTypeId", defaultValue = "") Long soleTypeId,
            @RequestParam(name = "colorId", defaultValue = "") Long colorId,
            @RequestParam(name = "sizeId", defaultValue = "") Long sizeId
    ) {
        List<ProductDetail> listFilter = prodcutDetailService.filterShoeDetails(brandId, categoryId, fabricTypeId, soleTypeId, colorId, sizeId);
        return ResponseEntity.ok(listFilter);
    }

    @GetMapping("/{shoeId}")
    public String deleteShoe(@PathVariable Long shoeId, Model model) {
        prodcutDetailService.deleteShoeDetails(shoeId);
        return "redirect:/shoes";
    }

//    @PostMapping("/")
//    public ResponseEntity<Product> addProductWithDetails(@RequestBody ProductRequest productRequest) {
//        Product createdProduct = prodcutDetailService.addProductWithDetails(productRequest);
//        return ResponseEntity.ok(createdProduct);
//    }

}
