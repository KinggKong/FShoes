package com.example.fshoes.controllers;

import com.example.fshoes.entities.Color;
import com.example.fshoes.services.impl.ColorService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colors")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ColorController {
    ColorService colorService;

    @GetMapping("/")
    public String index(Model model) {
        return "home/color";
    }

    @PostMapping("/")
    public String AddColor(@RequestParam("colorName") String colorName) {
        colorService.addColor(colorName);
        return "redirect:/colors/";
    }

    @PostMapping("/update")
    public String UpdateColor(@ModelAttribute("color") Color color) {
        colorService.updateColor(color);
        return "redirect:/colors/";
    }

    @GetMapping("/detail/{id}")
    public String getColorDetail(@PathVariable("id") Long colorId, Model model) {
        model.addAttribute("color", colorService.findColorById(colorId));
        return "home/color";
    }

    @GetMapping("/{id}")
    public String DeleteColor(@PathVariable("id") Long idColor) {
        colorService.deleteColor(idColor);
        return "redirect:/colors/";
    }
}
