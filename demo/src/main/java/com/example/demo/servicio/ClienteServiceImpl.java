package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repo;

    @Override
    public Cliente findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Cliente> findAll() {
        return repo.findAll();
    }

}
