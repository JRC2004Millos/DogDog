package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Cliente;
import com.example.demo.model.Veterinario;
import com.example.demo.service.ClienteService;
import com.example.demo.service.VeterinarioService;

@Controller
@RequestMapping("/dogdog")
public class HomeController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;

    // http://localhost:8080/dogdog/home
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    // http://localhost:8080/dogdog/login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // http://localhost:8080/dogdog/login
    @PostMapping("/login")
    public ModelAndView login(
            @RequestParam("type") String type,
            @RequestParam(value = "cedulaVeterinario", required = false) Integer cedulaVeterinario,
            @RequestParam(value = "passwordVet", required = false) String passwordVet,
            @RequestParam(value = "usuario", required = false) String usuario,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "cedula", required = false) Integer cedula,
            Model model) {

        String errorMessage = null;

        switch (type) {
            case "1": // Veterinario
                if (cedulaVeterinario == null || passwordVet == null) {
                    errorMessage = "Datos de veterinario incompletos.";
                    break;
                }

                Veterinario veterinario = veterinarioService.findByCedulaAndClave(cedulaVeterinario, passwordVet);
                if (veterinario != null) {
                    return new ModelAndView("redirect:/veterinario/" + veterinario.getId());
                }

                errorMessage = "Veterinario no encontrado";
                break;

            // case "2": // Administrador
            // if (usuario == null || password == null) {
            // errorMessage = "Datos de administrador incompletos.";
            // break;
            // }

            // Administrador administrador =
            // administradorService.findByUsuarioAndClave(usuario, password);
            // if (administrador != null) {
            // return new ModelAndView("redirect:/administrador");
            // }

            // errorMessage = "Administrador no encontrado";
            // break;

            case "3": // Cliente
                if (cedula == null) {
                    errorMessage = "Datos de cliente incompletos.";
                    break;
                }

                Cliente cliente = clienteService.findByCedula(cedula);
                if (cliente != null) {
                    return new ModelAndView("redirect:/clientes/ver/" + cliente.getId());
                }

                errorMessage = "Cliente no encontrado";
                break;

            default:
                errorMessage = "Tipo de usuario no válido";
        }

        // Si llegamos aquí, significa que hubo un error
        model.addAttribute("errorMessage", errorMessage);
        return new ModelAndView("pagina_error");
    }

    // http://localhost:8080/dogdog/register
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // http://localhost:8080/dogdog/administrador
    @GetMapping("/administrador")
    public String administrador() {
        return "administrador";
    }

    // http://localhost:8080/dogdog/cliente
    @GetMapping("/cliente")
    public String cliente() {
        return "cliente";
    }

    // http://localhost:8080/dogdog/veterinario
    @GetMapping("/veterinario")
    public String veterinario() {
        return "vet_home";
    }
}
