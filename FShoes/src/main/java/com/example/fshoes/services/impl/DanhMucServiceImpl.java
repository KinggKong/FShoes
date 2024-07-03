package com.example.fshoes.services.impl;

import com.example.fshoes.entities.DanhMuc;
import com.example.fshoes.repositories.DanhMucRepository;
import com.example.fshoes.services.DanhMucService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DanhMucServiceImpl implements DanhMucService {
    private final DanhMucRepository danhMucRepository;
    @Override
    public List<DanhMuc> getDanhMuc() {
        return danhMucRepository.findAll();
    }

    @Override
    public Page<DanhMuc> pagination(Pageable pageable) {
        return danhMucRepository.findAll(pageable);
    }

    @Override
    public void addDanhMuc(String danhMucName) {
        DanhMuc dm=new DanhMuc();
        dm.setName(danhMucName);
        danhMucRepository.save(dm);
    }

    @Override
    public void deleteDanhMuc(Long id) {
        danhMucRepository.deleteById(id);
    }

    @Override
    public void updateDanhMuc(DanhMuc danhMuc) {
        danhMucRepository.save(danhMuc);
    }

    @Override
    public DanhMuc findDanhMucById(Long id) {
        return danhMucRepository.findById(id).orElse(null);
    }
}
