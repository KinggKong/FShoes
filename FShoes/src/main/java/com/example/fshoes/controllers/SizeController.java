package com.example.fshoes.controllers;


import com.example.fshoes.entities.Size;
import com.example.fshoes.services.impl.SizeService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sizes")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)

public class SizeController {
    SizeService sizeService;

    @GetMapping("/list")
    public String index(Model model) {
        return "home/size";
    }

    @ModelAttribute("sizes")
    public List<Size> sizes() {
        return sizeService.getSize();
    }

    @PostMapping("/add")
    public String AddSize(@RequestParam("sizeName") String sizeName) {
        sizeService.addSize(sizeName);
        return "redirect:/sizes/list";
    }

    @PostMapping("/update")
    public String UpdateSize(@ModelAttribute("size") Size size) {
        sizeService.updateSize(size);
        return "redirect:/sizes/list";
    }

    @GetMapping("/detail/{id}")
    public String getSizeDetail(@PathVariable("id") Long sizeID, Model model) {
        model.addAttribute("size", sizeService.findSizeById(sizeID));
        return "home/size";
    }

    @GetMapping("delete/{id}")
    public String DeleteSize(@PathVariable("id") Long idSize) {
        sizeService.deleteSize(idSize);
        return "redirect:/sizes/list";
    }
}
