package com.example.fshoes.controllers;

import com.example.fshoes.entities.*;
import com.example.fshoes.repositories.CategoryRepository;
import com.example.fshoes.repositories.ProductDetailRepo;
import com.example.fshoes.services.impl.*;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class GlobalControllerAdvice {
    ColorService colorService;
    SoleService soleService;
    FabricService fabricService;
    BrandService brandService;
    CategoryRepository categoryRepository;
    SizeService sizeService;
    ProductDetailRepo productDetailRepo;

    @ModelAttribute("colors")
    public List<Color> colors() {
        return colorService.getColors();
    }

    @ModelAttribute("soles")
    public List<Sole> soles() {
        return soleService.getAll();
    }

    @ModelAttribute("fabrics")
    public List<Fabric> fabrics() {
        return fabricService.getAll();
    }

    @ModelAttribute("brands")
    public List<Brand> brands() {
        return brandService.getAll();
    }

    @ModelAttribute("sizes")
    public List<Size> sizes() {
        return sizeService.getSize();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("productdetais")
    public List<ProductDetail> productDetails() {
        return productDetailRepo.findAll();
    }
}
