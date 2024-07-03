package com.example.fshoes.services;

import com.example.fshoes.entities.Color;
import com.example.fshoes.entities.DanhMuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DanhMucService {
    List<DanhMuc> getDanhMuc();

    Page<DanhMuc> pagination(Pageable pageable);

    void addDanhMuc(String danhMucName);

    void deleteDanhMuc(Long id);

    void updateDanhMuc(DanhMuc danhMuc);

    DanhMuc findDanhMucById(Long id);
}
