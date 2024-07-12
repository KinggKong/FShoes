package com.example.fshoes.services.impl;

import com.example.fshoes.entities.ProductDetail;
import com.example.fshoes.repositories.ShoeDetailRepo;
import com.example.fshoes.services.IShoeDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ShoeDetailService implements IShoeDetailService {
    ShoeDetailRepo shoeDetailRepo;

    @Override
    public List<ProductDetail> getShoeDetails() {
        return shoeDetailRepo.findAll();
    }

    @Override
    public List<ProductDetail> filterShoeDetails(Long brandId, Long categoryId, Long fabricId, Long soleId, Long colorId, Long sizeId) {
        List<ProductDetail> shoeDetails = shoeDetailRepo.getAllByFilter(brandId, categoryId, fabricId, soleId, colorId, sizeId);
        return shoeDetails;
    }

    @Override
    public void deleteShoeDetails(Long shoeId) {
        shoeDetailRepo.deleteById(shoeId);
    }

}
