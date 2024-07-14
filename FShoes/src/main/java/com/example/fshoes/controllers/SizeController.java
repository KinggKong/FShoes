package com.example.fshoes.controllers;


import com.example.fshoes.entities.Size;
import com.example.fshoes.services.impl.SizeService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sizes")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
//@ResponseBody
public class SizeController {

    @Autowired
    SizeService sizeService;

    private static final int Page_size = 5;

//    @GetMapping("/list")
//    public String listSize(Model model, @RequestParam(name = "p", defaultValue = "0") int p) {
//        Sort sort = Sort.by(Sort.Direction.ASC, "id");
//        Pageable pageable = PageRequest.of(p, Page_size, sort);
//        Page<Size> page = sizeService.pagination(pageable);
//        model.addAttribute("sizes", page);
//        return "home/size";
//    }

//    @GetMapping("/api/list")
//    public List<Size> listSizesForApi() {
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        Pageable pageable = PageRequest.of(0, Page_size, sort);
//        Page<Size> page = sizeService.pagination(pageable);
//        return page.getContent();
//    }


    @GetMapping("/list")
    public String listSize(Model model, @RequestParam(name = "p", defaultValue = "0") int p) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(p, Page_size, sort);
        Page<Size> page = sizeService.pagination(pageable);
        int totalPages = page.getTotalPages();
        model.addAttribute("sizes", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", p);
        return "home/size";
    }


    @PostMapping("/add")
    public String AddSize(@RequestParam("sizeName") String sizeName, RedirectAttributes redirectAttributes) {
        sizeService.addSize(sizeName);
        redirectAttributes.addFlashAttribute("message", "Thêm dữ liệu thành công!");
        return "redirect:/sizes/list";
    }

//    @PostMapping("/update")
//    public String UpdateSize(@ModelAttribute("size") Size size, RedirectAttributes redirectAttributes) {
//        sizeService.updateSize(size);
//        redirectAttributes.addFlashAttribute("message2", "Sửa dữ liệu thành công!");
//        return "redirect:/sizes/list";
//    }
//
//    @GetMapping("/detail/{id}")
//    public String getSizeDetail(@PathVariable("id") Long sizeID, Model model) {
//        Size size = sizeService.findSizeById(sizeID);
//        model.addAttribute("size", size);
//        return "home/size";
//    }

    @PostMapping("/update")
    public String UpdateSize(@RequestParam("sizeId") Long sizeId,
                             @RequestParam("sizeName") String sizeName,  RedirectAttributes redirectAttributes) {
        Size updateSize = new Size();
        updateSize.setId(sizeId);
        updateSize.setName(sizeName);
        redirectAttributes.addFlashAttribute("message2", "Update dữ liệu thành công");

        sizeService.updateSize(updateSize);
        return "redirect:/sizes/list";
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<Size> getSizeDetail(@PathVariable("id") Long sizeId, Model model) {
        Size color = sizeService.findSizeById(sizeId);
        model.addAttribute("size", sizeService.findSizeById(sizeId));
        return ResponseEntity.ok(color);
    }

    @GetMapping("delete/{id}")
    public String DeleteSize(@PathVariable("id") Long idSize, RedirectAttributes redirectAttributes) {
        sizeService.deleteSize(idSize);
        redirectAttributes.addFlashAttribute("message1", "Xóa dữ liệu thành công!");

        return "redirect:/sizes/list";
    }
}