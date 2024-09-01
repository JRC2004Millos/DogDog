package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.VeterinarioService;

@Controller
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    // http://localhost:8080/veterinario/{id}
    @GetMapping("/veterinario/{id}")
    public String home(@PathVariable("id") Long id, Model model) {
        model.addAttribute("veterinario", veterinarioService.findById(id));
        return "vet_home";
    }
}
