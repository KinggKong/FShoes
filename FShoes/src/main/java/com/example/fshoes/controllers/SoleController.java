package com.example.fshoes.controllers;

import com.example.fshoes.services.impl.SoleService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/soles")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class SoleController {
    SoleService soleService;
    @GetMapping("/")
    public String index() {
        return "home/sole";
    }
}
