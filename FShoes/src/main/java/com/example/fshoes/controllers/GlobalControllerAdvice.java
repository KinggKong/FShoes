package com.example.fshoes.controllers;

import com.example.fshoes.entities.Color;
import com.example.fshoes.entities.Fabric;
import com.example.fshoes.entities.Sole;
import com.example.fshoes.services.impl.ColorService;
import com.example.fshoes.services.impl.FabricService;
import com.example.fshoes.services.impl.SoleService;
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
    SoleService soleService;
    FabricService fabricService;
    @ModelAttribute("colors")
    public List<Color> colors() {
        return colorService.getColors();
    }

    //getList sole
    @ModelAttribute("soles")
    public List<Sole> soles() {
        return soleService.getAll();
    }
    @ModelAttribute("fabrics")
    public List<Fabric> fabrics() {
        return fabricService.getAll();
    }
}
