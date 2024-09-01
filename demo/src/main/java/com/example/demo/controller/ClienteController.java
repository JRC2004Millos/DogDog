package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;
import com.example.error.NotFoundException;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/ver")
    public String mostrarClientes(Model model, @RequestParam("veterinarioId") Long veterinarioId) {
        model.addAttribute("clientes", service.findAll());
        model.addAttribute("veterinarioId", veterinarioId);
        return "mostrar_clientes";
    }

    // http://localhost:8080/clientes/ver/{id}
    @GetMapping("/ver/{id}")
    public String home(Model model, @PathVariable("id") Long identificacion) {
        Cliente cliente = service.findById(identificacion);

        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("mascotas", mascotaService.findByDuenoId(identificacion));
        } else {
            throw new NotFoundException(identificacion);
        }
        return "cliente";
    }

    // http://localhost:8080/clientes/agregar
    @GetMapping("/agregar")
    public String agregarCliente(Model model, @RequestParam("veterinarioId") Long veterinarioId) {
        Cliente cliente = new Cliente(0, "", "", 0);

        model.addAttribute("veterinarioId", veterinarioId);
        model.addAttribute("cliente", cliente);

        return "agregar_cliente";
    }

    // http://localhost:8080/clientes/agregar
    @PostMapping("/agregar")
    public String agregarCliente(@ModelAttribute("Cliente") Cliente cliente,
            @RequestParam("veterinarioId") Long veterinarioId) {
        service.add(cliente);
        return "redirect:/clientes/ver?veterinarioId=" + veterinarioId;
    }

    // http://localhost:8080/clientes/eliminar/{id}
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long identificacion,
            @RequestParam("veterinarioId") Long veterinarioId) {
        service.deleteById(identificacion);
        return "redirect:/clientes/ver?veterinarioId=" + veterinarioId;
    }

    // http://localhost:8080/clientes/modificar/{id}
    @GetMapping("/modificar/{id}")
    public String modificarCliente(Model model, @PathVariable("id") Long identificacion,
            @RequestParam("veterinarioId") Long veterinarioId) {
        model.addAttribute("veterinarioId", veterinarioId);
        model.addAttribute("cliente", service.findById(identificacion));
        return "modificar_cliente";
    }

    // http://localhost:8080/clientes/modificar
    @PostMapping("/modificar/{id}")
    public String modificarCliente(@ModelAttribute("cliente") Cliente cliente,
            @RequestParam("veterinarioId") Long veterinarioId) {
        service.update(cliente);
        return "redirect:/clientes/ver?veterinarioId=" + veterinarioId;
    }

}