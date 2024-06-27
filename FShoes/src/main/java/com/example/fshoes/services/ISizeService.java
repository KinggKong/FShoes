package com.example.fshoes.services;

import com.example.fshoes.entities.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISizeService {
    List<Size> getSize();

    Page<Size> pagination(Pageable pageable);

    void addSize(String sizeName);

    void deleteSize(Long id);

    void updateSize(Size size);

    Size findSizeById(Long id);
}
