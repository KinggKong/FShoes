package com.example.fshoes.controllers;

import com.example.fshoes.entities.Color;
import com.example.fshoes.services.impl.ColorService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class GlobalControllerAdvice {
    ColorService colorService;

    @ModelAttribute("colors")
    public List<Color> colors() {
        return colorService.getColors();
    }
}
