package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // http://localhost:8080/clientes/{id}
    @RequestMapping("/ver/{id}")
    public String home(Model model, @PathVariable("id") int identificacion) {
        Cliente cliente = service.findById(identificacion);

        if (cliente != null) {
            model.addAttribute("cliente", service.findById(identificacion));
        } else {
            throw new NotFoundException(identificacion);
        }
        return "cliente";

    }

}
