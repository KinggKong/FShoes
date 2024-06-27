package com.example.fshoes.controllers;


import com.example.fshoes.entities.Color;
import com.example.fshoes.entities.Size;
import com.example.fshoes.services.impl.ColorService;
import com.example.fshoes.services.impl.SizeService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/size")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)

public class SizeController {
    SizeService sizeService;

    @GetMapping("")
    public String index(Model model) {
        return "home/size";
    }

    @PostMapping("/")
    public String AddSize(@RequestParam("sizeName") String sizeName) {
        sizeService.addSize(sizeName);
        return "redirect:/size";
    }

    @PostMapping("/update")
    public String UpdateColor(@ModelAttribute("size") Size size) {
        sizeService.updateSize(size);
        return "redirect:/size";
    }

    @GetMapping("/detail/{id}")
    public String getColorDetail(@PathVariable("id") Long sizeID, Model model) {
        model.addAttribute("size", sizeService.findSizeById(sizeID));
        return "home/size";
    }

    @GetMapping("/{id}")
    public String DeleteColor(@PathVariable("id") Long idSize) {
        sizeService.deleteSize(idSize);
        return "redirect:/size";
    }
}
