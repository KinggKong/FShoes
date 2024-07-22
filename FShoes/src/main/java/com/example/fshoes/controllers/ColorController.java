package com.example.fshoes.controllers;

import com.example.fshoes.entities.Color;
import com.example.fshoes.services.impl.ColorService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colors")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ColorController {
    ColorService colorService;

    @GetMapping("")
    public String index(Model model) {
        return "home/color";
    }

    @PostMapping("/")
    public String AddColor(@RequestParam("colorName") String colorName) {
        colorService.addColor(colorName);
        return "redirect:/colors";
    }

    @PostMapping("/update")
    public String UpdateColor(@RequestParam("colorId") Long colorId,
                              @RequestParam("colorName") String colorName) {
        Color updateColor = new Color();
        updateColor.setId(colorId);
        updateColor.setName(colorName);
        colorService.updateColor(updateColor);
        return "redirect:/colors";
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<Color> getColorDetail(@PathVariable("id") Long colorId, Model model) {
        Color color = colorService.findColorById(colorId);
        model.addAttribute("color", colorService.findColorById(colorId));
        return ResponseEntity.ok(color);
    }

    @GetMapping("/{id}")
    public String DeleteColor(@PathVariable("id") Long idColor) {
        colorService.deleteColor(idColor);
        return "redirect:/colors";
    }
}
