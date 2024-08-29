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
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/ver")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", service.findAll());
        return "mostrar_clientes";
    }

    // http://localhost:8080/clientes/{id}
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
    public String agregarCliente(Model model) {
        Cliente cliente = new Cliente(0, "", "", 0);

        model.addAttribute("cliente", cliente);

        return "agregar_cliente";
    }

    // http://localhost:8080/clientes/agregar
    @PostMapping("/agregar")
    public String agregarCliente(@ModelAttribute("Cliente") Cliente cliente) {
        service.add(cliente);
        return "redirect:/clientes/ver";
    }

    // http://localhost:8080/clientes/eliminar/{id}
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long identificacion) {
        service.deleteById(identificacion);
        return "redirect:/clientes/ver";
    }

    // http://localhost:8080/clientes/modificar/{id}
    @GetMapping("/modificar/{id}")
    public String modificarCliente(Model model, @PathVariable("id") Long identificacion) {
        model.addAttribute("cliente", service.findById(identificacion));
        return "modificar_cliente";
    }

    // http://localhost:8080/clientes/modificar
    @PostMapping("/modificar/{id}")
    public String modificarCliente(@ModelAttribute("cliente") Cliente cliente) {
        service.update(cliente);
        return "redirect:/clientes/ver";
    }

}