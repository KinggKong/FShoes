package com.example.fshoes.services.impl;


import com.example.fshoes.entities.Size;
import com.example.fshoes.repositories.SizeRepo;
import com.example.fshoes.services.ISizeService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)

public class SizeService implements ISizeService {

    @Autowired
    SizeRepo sizeRepo;


    @Override
    public List<Size> getSize() {
        return sizeRepo.findAll();
    }

    @Override
    public Page<Size> pagination(Pageable pageable) {
        return sizeRepo.findAll(pageable);
    }

    @Override
    public void addSize(String sizeName) {
        Size size = new Size();
        size.setName(sizeName);
        size.setStatus(1);
        sizeRepo.save(size);
    }

    @Override
    public void deleteSize(Long id) {
        sizeRepo.deleteById(id);
    }

    @Override
    public void updateSize(Size size) {
        sizeRepo.save(size);
    }

    @Override
    public Size findSizeById(Long id) {
        return sizeRepo.findById(id).orElse(null);
    }
}
