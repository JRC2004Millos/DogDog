package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Veterinario;
import com.example.demo.service.VeterinarioService;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin("http://localhost:4200")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    // http://localhost:8080/veterinario/{id}
    @GetMapping("/{id}")
    public Veterinario home(@PathVariable("id") Long id) {
        return veterinarioService.findById(id);
    }

    // CRUD VETERINARIO -> Pasar a JSON para entrega 9
    // http://localhost:8080/veterinario/id}
    @GetMapping("/cedula/{cedula}")
    public Veterinario mostrarClienteByCedula(@PathVariable("cedula") int cedula) {
        return veterinarioService.findByCedula(cedula);
    }

    // http://localhost:8080/veterinario/agregar
    @GetMapping("/agregar")
    public String agregar(Model model) {
        Veterinario veterinario = new Veterinario("", 0, "", "", "", 0);

        model.addAttribute("veterinario", veterinario);

        return "agregar_vet";
    }

    // http://localhost:8080/veterinario/agregar
    @PostMapping("/agregar")
    public String agregar(Veterinario veterinario) {
        veterinarioService.add(veterinario);
        return "redirect:/veterinario/ver";
    }

    // http://localhost:8080/veterinario/modificar/{id}
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("veterinario", veterinarioService.findById(id));
        return "modificar_vet";
    }

    // http://localhost:8080/veterinario/modificar/{id}
    @PostMapping("/modificar/{id}")
    public String modificar(Veterinario veterinario) {
        veterinarioService.update(veterinario);
        return "redirect:/veterinario/ver";
    }

    // http://localhost:8080/veterinario/eliminar/{id}
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
        return "redirect:/veterinario/ver";
    }
}
