package com.example.fshoes.controllers;

import com.example.fshoes.entities.Fabric;
import com.example.fshoes.entities.Sole;
import com.example.fshoes.services.impl.FabricService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/fabrics/")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class FabricController {
    FabricService fabricService;
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("fabric", new Fabric());
        return "home/fabric";
    }
    @PostMapping("/")
    public String AddSole(@RequestParam("fabricName") String fabricName) {
        fabricService.add(fabricName);
        return "redirect:/fabrics/";
    }
    @GetMapping("/detail/{id}")
    public String getFabricDetail(@PathVariable("id") Long Id, Model model) {
        Fabric fabric = fabricService.findById(Id);
        model.addAttribute("fabric", fabric);
        return "home/fabric";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute("fabric") Fabric fabric) {
        fabricService.update(fabric);
        return "redirect:/fabrics/";
    }
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") Long id) {
        fabricService.delete(id);
        return "redirect:/fabrics/";
    }
}
