package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private ClienteService clienteService;

    // http://localhost:8080/mascotas/ver
    @GetMapping("/ver")
    public String mostrarMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.findAll());
        return "mostrar_mascotas";
    }

    // http://localhost:8080/mascotas/buscar/{id}
    @GetMapping("/buscar/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") Long identificacion) {
        model.addAttribute("mascota", mascotaService.findById(identificacion));
        return "mostrar_mascota";
    }

    // http://localhost:8080/mascotas/agregar
    @GetMapping("/agregar")
    public String agregarMascota(Model model) {
        Mascota mascota = new Mascota("", "", 0, 0, "");
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "agregar_mascota";
    }

    @PostMapping("/agregar")
    public String agregarMascota(@ModelAttribute("mascota") Mascota mascota) {
        Cliente cliente = clienteService.findById(mascota.getCliente().getId());
        mascota.setCliente(cliente);
        mascotaService.add(mascota);
        return "redirect:/mascotas/ver";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") Long identificacion) {
        mascotaService.deleteById(identificacion);
        return "redirect:/mascotas/ver";
    }

    // http://localhost:8080/mascotas/modificar/{id}
    @GetMapping("/modificar/{id}")
    public String modificarMascota(Model model, @PathVariable("id") Long identificacion) {
        Mascota mascota = mascotaService.findById(identificacion);
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "modificar_mascota";
    }

    @PostMapping("/modificar/{id}")
    public String modificarMascota(@PathVariable("id") Long id, @ModelAttribute("mascota") Mascota mascota) {
        Mascota mascotaExistente = mascotaService.findById(id);
        if (mascotaExistente != null) {
            mascota.setId(id);
            Cliente cliente = clienteService.findById(mascota.getCliente().getId());
            mascota.setCliente(cliente);
            mascotaService.update(mascota);
        }
        return "redirect:/mascotas/ver";
    }
}