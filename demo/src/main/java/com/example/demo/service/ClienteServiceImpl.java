package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    public ClienteRepository repo;

    @Override
    public Cliente findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Cliente findByCedula(int cedula) {
        return repo.findByCedula(cedula);
    }

    @Override
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @Override
    public void add(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        repo.save(cliente);
    }

}
