package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/ver")
    public List<Cliente> mostrarClientes() {
        return service.findAll();
    }

    // http://localhost:8080/clientes/ver/{id}
    @GetMapping("/ver/{id}")
    public Cliente mostrarCliente(@PathVariable("id") Long identificacion) {
        return service.findById(identificacion);
    }

    // http://localhost:8080/clientes/ver/{id}
    @GetMapping("/cedula/{cedula}")
    public Cliente mostrarClienteByCedula(@PathVariable("cedula") int cedula) {
        return service.findByCedula(cedula);
    }

    // http://localhost:8080/clientes/ver/{id}/mascotas
    @GetMapping("/ver/{id}/mascotas")
    public List<Mascota> mostrarMascotasCliente(@PathVariable("id") Long identificacion) {
        return mascotaService.findByDuenoId(identificacion);
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
    public void agregarCliente(@RequestBody Cliente cliente) {
        service.add(cliente);
    }

    // http://localhost:8080/clientes/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCliente(@PathVariable("id") Long identificacion) {
        service.deleteById(identificacion);
    }

    // http://localhost:8080/clientes/modificar/{id}
    @GetMapping("/modificar/{id}")
    public String modificarCliente(Model model, @PathVariable("id") Long identificacion,
            @RequestParam("veterinarioId") Long veterinarioId) {
        model.addAttribute("veterinarioId", veterinarioId);
        model.addAttribute("cliente", service.findById(identificacion));
        return "modificar_cliente";
    }

    // http://localhost:8080/clientes/modificar/{id}
    @PutMapping("/modificar")
    public void modificarCliente(@RequestBody Cliente cliente) {
        Cliente original = service.findById(cliente.getId());
        cliente.setMascotas(original.getMascotas());
        service.update(cliente);
    }
}
