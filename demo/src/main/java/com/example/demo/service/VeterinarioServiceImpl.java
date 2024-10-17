package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Veterinario;
import com.example.demo.repository.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    private VeterinarioRepository repo;

    @Override
    public Veterinario findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Veterinario findByCedula(int cedula) {
        return repo.findByCedula(cedula);
    }

    @Override
    public List<Veterinario> findAll() {
        return repo.findAll();
    }

    @Override
    public void add(Veterinario veterinario) {
        repo.save(veterinario);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Veterinario veterinario) {
        repo.save(veterinario);
    }

    @Override
    public int countByEstado(boolean estado) {
        return repo.countByEstado(estado);
    }
}
