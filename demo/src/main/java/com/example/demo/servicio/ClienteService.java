package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;

@Service
public interface ClienteService {

    public Cliente findById(int id);

    public Collection<Cliente> findAll();
}