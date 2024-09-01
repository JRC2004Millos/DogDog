package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;

@Service
public interface ClienteService {

    public Cliente findById(Long id);

    public Cliente findByCedula(int cedula);

    public Collection<Cliente> findAll();

    public void add(Cliente cliente);

    public void deleteById(Long id);

    public void update(Cliente cliente);
}
