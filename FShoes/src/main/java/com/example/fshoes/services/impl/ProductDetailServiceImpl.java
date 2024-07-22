package com.example.fshoes.services.impl;

import com.example.fshoes.dto.request.ProductDetailRequest;
import com.example.fshoes.dto.response.ProductDetailResponse;
import com.example.fshoes.entities.Brand;
import com.example.fshoes.entities.Category;
import com.example.fshoes.entities.Color;
import com.example.fshoes.entities.Fabric;
import com.example.fshoes.entities.Product;
import com.example.fshoes.entities.ProductDetail;
import com.example.fshoes.entities.Size;
import com.example.fshoes.entities.Sole;
import com.example.fshoes.repositories.BrandRepository;
import com.example.fshoes.repositories.CategoryRepository;
import com.example.fshoes.repositories.ColorRepo;
import com.example.fshoes.repositories.FabricRepo;
import com.example.fshoes.repositories.ProductDetailRepository;
import com.example.fshoes.repositories.ProductRepository;
import com.example.fshoes.repositories.ShoeRepo;
import com.example.fshoes.repositories.SizeRepo;
import com.example.fshoes.repositories.SoleRepo;
import com.example.fshoes.services.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepository productDetailRepository;
    private final ColorRepo colorRepo;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final FabricRepo fabricRepo;
    private final SoleRepo soleRepo;
    private final SizeRepo sizeRepo;
    private final BrandRepository brandRepository;

    @Override
    public Page<ProductDetailResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public String add(ProductDetailRequest request) {
        Product product = productRepository.findById(request.getProductId()).orElse(null);
        Color color = colorRepo.findById(request.getColorId()).orElse(null);
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        Fabric fabric = fabricRepo.findById(request.getFabricId()).orElse(null);
        Sole sole = soleRepo.findById(request.getSoleId()).orElse(null);
        Size size = sizeRepo.findById(request.getSizeId()).orElse(null);
        Brand brand = brandRepository.findById(request.getBrandId()).orElse(null);
        productDetailRepository.save(ProductDetail.builder()
                .id(null)
                .color(color)
                .product(product)
                .size(size)
                .brand(brand)
                .category(category)
                .fabric(fabric)
                .sole(sole)
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .status(1)
                .build());
        return "Thêm thành công";
    }

    @Override
    public String update(ProductDetailRequest request, Long id) {
        Product product = productRepository.findById(request.getProductId()).orElse(null);
        Color color = colorRepo.findById(request.getColorId()).orElse(null);
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        Fabric fabric = fabricRepo.findById(request.getFabricId()).orElse(null);
        Sole sole = soleRepo.findById(request.getSoleId()).orElse(null);
        Size size = sizeRepo.findById(request.getSizeId()).orElse(null);
        Brand brand = brandRepository.findById(request.getBrandId()).orElse(null);
        productDetailRepository.save(ProductDetail.builder()
                .id(id)
                .color(color)
                .product(product)
                .size(size)
                .brand(brand)
                .category(category)
                .fabric(fabric)
                .sole(sole)
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .status(request.getStatus())
                .build());
        return "Update thành công";
    }

    @Override
    public String delete(Long id) {
        productDetailRepository.deleteById(id);
        return "Delete successfully";
    }

    @Override
    public ProductDetail getProductDetailById(Long id) {
        return productDetailRepository.findById(id).get();
    }

    @Override
    public void updateQuantityProductDetail(Long id, Integer quantity, String action) {
        ProductDetail productDetail = productDetailRepository.findById(id).get();
        if (action.equalsIgnoreCase("minus")) {
            productDetail.setQuantity(productDetail.getQuantity() - quantity);
        } else {
            productDetail.setQuantity(productDetail.getQuantity() + quantity);
        }
        productDetailRepository.save(productDetail);
    }

    @Override
    public boolean exists(Long id) {
        return productDetailRepository.existsById(id);
    }
}
