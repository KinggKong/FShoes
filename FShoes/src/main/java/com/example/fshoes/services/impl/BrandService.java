package com.example.fshoes.services.impl;

import com.example.fshoes.entities.Brand;
import com.example.fshoes.repositories.BrandRepo;
import com.example.fshoes.services.IBrandService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BrandService implements IBrandService {
    BrandRepo brandRepo;
    @Override
    public List<Brand> getAll() {
        return brandRepo.findAll();
    }

    @Override
    public Page<Brand> pagination(Pageable pageable) {
        return brandRepo.findAll(pageable);
    }

    @Override
    public void add(String name) {
        Brand newBrand = new Brand();
        newBrand.setName(name);
        brandRepo.save(newBrand);
    }

    @Override
    public void delete(Long id) {
        brandRepo.deleteById(id);

    }

    @Override
    public void update(Brand brand) {
        brandRepo.save(brand);
    }

    @Override
    public Brand findBrandById(Long id) {
        return brandRepo.findById(id).orElse(null);
    }
}
