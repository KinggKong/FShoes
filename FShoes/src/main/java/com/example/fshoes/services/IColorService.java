package com.example.fshoes.services;

import com.example.fshoes.entities.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IColorService {
    List<Color> getColors();

    Page<Color> pagination(Pageable pageable);

    void addColor(String colorName);

    void addSize(String colorName);

    void deleteColor(Long id);

    void updateColor(Color color);

    Color findColorById(Long id);
}
