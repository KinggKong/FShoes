package com.example.fshoes.services;

import com.example.fshoes.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DanhMucService {
    List<Category> getDanhMuc();

    Page<Category> pagination(Pageable pageable);

    void addDanhMuc(String danhMucName);

    void deleteDanhMuc(Long id);

    void updateDanhMuc(Category category);

    Category findDanhMucById(Long id);
}
