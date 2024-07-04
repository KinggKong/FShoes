package com.example.fshoes.services;

import com.example.fshoes.entities.Brand;
import com.example.fshoes.entities.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBrandService {
    List<Brand> getAll();

    Page<Brand> pagination(Pageable pageable);

    void add(String name);

    void delete(Long id);

    void update(Brand brand);

    Brand findBrandById(Long id);
}
