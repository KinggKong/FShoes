package com.example.fshoes.controllers;

import com.example.fshoes.entities.*;
import com.example.fshoes.repositories.DanhMucRepository;
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
    DanhMucRepository danhMucRepository;
    SizeService sizeService;
    ProductDetailRepo productDetailRepo;
    @ModelAttribute("colors")
    public List<Color> colors() {
        return colorService.getColors();
    }

    //getList sole
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
    @ModelAttribute("danhmucs")
    public List<DanhMuc> danhMucs() {
        return danhMucRepository.findAll();
    }
    @ModelAttribute("sizes")
    public List<Size> sizes() {
        return sizeService.getSize();
    }

    @ModelAttribute("productdetais")
    public List<ProductDetail> productDetails() {
        return productDetailRepo.findAll();
    }
}
