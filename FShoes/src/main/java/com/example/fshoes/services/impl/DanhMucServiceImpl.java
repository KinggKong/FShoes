package com.example.fshoes.services.impl;

import com.example.fshoes.entities.Category;
import com.example.fshoes.repositories.CategoryRepository;
import com.example.fshoes.services.DanhMucService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DanhMucServiceImpl implements DanhMucService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getDanhMuc() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> pagination(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void addDanhMuc(String danhMucName) {
        Category dm=new Category();
        dm.setName(danhMucName);
        categoryRepository.save(dm);
    }

    @Override
    public void deleteDanhMuc(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateDanhMuc(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findDanhMucById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
