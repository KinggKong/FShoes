package com.example.fshoes.controllers;

import com.example.fshoes.entities.Category;
import com.example.fshoes.services.DanhMucService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final DanhMucService danhMucService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("danhmucs", danhMucService.getDanhMuc());
        return "home/danhmuc";
    }

    @PostMapping("/")
    public String AddDanhMuc(@RequestParam("danhMucName") String danhMucName) {
        danhMucService.addDanhMuc(danhMucName);
        return "redirect:/danh-muc";
    }

    @PostMapping("/update")
    public String UpdateDanhMuc(@RequestParam("danhMucId") Long danhMucId,
                                @RequestParam("danhMucName") String danhMucName) {
        Category updateDm = new Category();
        updateDm.setId(danhMucId);
        updateDm.setName(danhMucName);
        danhMucService.updateDanhMuc(updateDm);
        return "redirect:/danh-muc";
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<?> getDanhMucDetail(@PathVariable("id") Long danhMucId, Model model) {
        Category dm = danhMucService.findDanhMucById(danhMucId);
        model.addAttribute("danhmuc", danhMucService.findDanhMucById(danhMucId));
        return ResponseEntity.ok(dm);
    }

    @GetMapping("/{id}")
    public String DeleteDanhMuc(@PathVariable("id") Long idDanhMuc) {
        danhMucService.deleteDanhMuc(idDanhMuc);
        return "redirect:/danh-muc";
    }
}
