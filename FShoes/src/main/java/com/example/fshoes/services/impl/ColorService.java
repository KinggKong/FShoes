package com.example.fshoes.services.impl;

import com.example.fshoes.entities.Color;
import com.example.fshoes.repositories.ColorRepo;
import com.example.fshoes.services.IColorService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ColorService implements IColorService {
    ColorRepo colorRepo;

    @Override
    public List<Color> getColors() {
        return colorRepo.findAll();
    }

    @Override
    public Page<Color> pagination(Pageable pageable) {
        return colorRepo.findAll(pageable);
    }

    @Override
    public void addColor(String colorName) {
        Color newColor = new Color();
        newColor.setName(colorName);
        colorRepo.save(newColor);
    }

    @Override
    public void deleteColor(Long id) {
        colorRepo.deleteById(id);
    }

    @Override
    public void updateColor(Color color) {
        colorRepo.save(color);
    }

    @Override
    public Color findColorById(Long id) {
        return colorRepo.findById(id).orElse(null);
    }
}
