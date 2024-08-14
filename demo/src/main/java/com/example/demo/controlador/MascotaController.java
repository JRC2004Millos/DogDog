package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.servicio.MascotaService;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaService service;

    // http://localhost:8080/mascota/ver
    @GetMapping("/ver")
    public String mostrarMascotas(Model model) {
        model.addAttribute("mascotas", service.findAll());
        return "mostrar_mascotas";
    }

    @GetMapping("/buscar/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") int identificacion) {
        model.addAttribute("mascota", service.findById(identificacion));
        return "mostrar_mascota";
    }
}