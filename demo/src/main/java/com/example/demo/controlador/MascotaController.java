package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Mascota;
import com.example.demo.servicio.MascotaService;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    MascotaService service;

    // http://localhost:8080/mascotas/ver
    @GetMapping("/ver")
    public String mostrarMascotas(Model model) {
        model.addAttribute("mascotas", service.findAll());
        return "mostrar_mascotas";
    }

    // http://localhost:8080/buscar/{id}
    @GetMapping("/buscar/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") int identificacion) {
        model.addAttribute("mascota", service.findById(identificacion));
        return "mostrar_mascota";
    }

    @GetMapping("/agregar")
    public String agregarMascota(Model model) {
        Mascota mascota = new Mascota(0, "", "", 0, 0, "", 0);

        model.addAttribute("mascota", mascota);

        return "agregar_mascota";
    }

    @PostMapping("/agregar")
    public String agregarMascota(@ModelAttribute("mascota") Mascota mascota) {
        service.add(mascota);
        return "redirect:/mascotas/ver";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") int identificacion) {
        service.deleteById(identificacion);
        return "redirect:/mascotas/ver";
    }

    @GetMapping("/modificar/{id}")
    public String modificarMascota(Model model, @PathVariable("id") int identificacion) {
        model.addAttribute("mascota", service.findById(identificacion));
        return "modificar_mascota";
    }

    @PostMapping("/modificar/{id}")
    public String modificarMascota(@ModelAttribute("mascota") Mascota mascota) {
        service.update(mascota);
        return "redirect:/mascotas/ver";
    }
}