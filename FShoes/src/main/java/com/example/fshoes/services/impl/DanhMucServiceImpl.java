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
    private final CategoryRepository danhMucRepository;
    @Override
    public List<Category> getDanhMuc() {
        return danhMucRepository.findAll();
    }

    @Override
    public Page<Category> pagination(Pageable pageable) {
        return danhMucRepository.findAll(pageable);
    }

    @Override
    public void addDanhMuc(String danhMucName) {
        Category dm=new Category();
        dm.setName(danhMucName);
        danhMucRepository.save(dm);
    }

    @Override
    public void deleteDanhMuc(Long id) {
        danhMucRepository.deleteById(id);
    }

    @Override
    public void updateDanhMuc(Category category) {
        danhMucRepository.save(category);
    }

    @Override
    public Category findDanhMucById(Long id) {
        return danhMucRepository.findById(id).orElse(null);
    }
}
