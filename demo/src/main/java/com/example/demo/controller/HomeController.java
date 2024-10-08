package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
