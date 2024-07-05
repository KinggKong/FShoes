package com.example.fshoes.services.impl;

import com.example.fshoes.dto.ProductDetailRequest;
import com.example.fshoes.dto.ProductRequest;
import com.example.fshoes.entities.Image;
import com.example.fshoes.entities.Product;
import com.example.fshoes.entities.ProductDetail;
import com.example.fshoes.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductDetailRepo productDetailRepo;

    @Autowired
    private DanhMucRepository categoryRepository;

    @Autowired
    private BrandRepo brandRepository;

    @Autowired
    private SizeRepo sizeRepository;

    @Autowired
    private ColorRepo colorRepository;

    @Autowired
    private SoleRepo soleRepository;
    @Autowired
    private FabricRepo fabricRepository;

    @Autowired
    private ImageRepo imageRepo;

    @Transactional
    public Product addProductWithDetails(ProductRequest productRequest) {
        // Tạo sản phẩm mới
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setDanhMuc(categoryRepository.findById(productRequest.getCategoryId()).orElse(null));
        product.setBrand(brandRepository.findById(productRequest.getBrandId()).orElse(null));
        product.setMaterial(fabricRepository.findById(productRequest.getMaterialId()).orElse(null));
        product.setSoleMaterial(soleRepository.findById(productRequest.getSoleMaterialId()).orElse(null));
        product.setStatus(productRequest.getStatus());
        product = productRepo.save(product);

        // Tạo các biến thể của sản phẩm
        for (ProductDetailRequest detailRequest : productRequest.getDetails()) {
            ProductDetail detail = new ProductDetail();
            detail.setProduct(product);
            detail.setSize(sizeRepository.findById(detailRequest.getSizeId()).orElse(null));
            detail.setColor(colorRepository.findById(detailRequest.getColorId()).orElse(null));
            detail.setQuantity(detailRequest.getQuantity());
            detail.setSalePrice(detailRequest.getSalePrice());
            detail.setProductCode(detailRequest.getProductCode());
            detail.setDescription(detailRequest.getDescription());
            detail.setStatus(detailRequest.getStatus());
            detail.setSrcImg(detailRequest.getSrc_img());
            productDetailRepo.save(detail);

        }

        return product;
    }
}
