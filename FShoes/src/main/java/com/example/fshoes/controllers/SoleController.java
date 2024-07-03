package com.example.fshoes.controllers;

import com.example.fshoes.entities.Sole;
import com.example.fshoes.services.impl.SoleService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/soles")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class SoleController {
    SoleService soleService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("sole", new Sole());
        return "home/sole";
    }
    @PostMapping("/")
    public String AddSole(@RequestParam("soleName") String soleName) {
        soleService.add(soleName);
        return "redirect:/soles/";
    }
    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<Sole> getSoleDetail(@PathVariable("id") Long soleId, Model model) {
        Sole sole = soleService.findById(soleId);
        model.addAttribute("sole", sole);
        return ResponseEntity.ok(sole);
    }
    @PostMapping("/update")
    public String UpdateSole(@RequestParam("id") Long id,
                             @RequestParam("name") String name) {
        Sole sole = new Sole();
        sole.setId(id);
        sole.setName(name);
        soleService.update(sole);
        return "redirect:/soles/";
    }
    @GetMapping("/delete/{id}")
    public String DeleteSole(@PathVariable("id") Long idSole) {
        soleService.delete(idSole);
        return "redirect:/soles/";
    }
}
