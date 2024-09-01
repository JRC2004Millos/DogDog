package com.example.demo.service;

import java.util.Collection;
import org.springframework.stereotype.Service;

import com.example.demo.model.Veterinario;

@Service
public interface VeterinarioService {

    public Veterinario findById(Long id);

    public Veterinario findByCedulaAndClave(int cedula, String clave);

    public Collection<Veterinario> findAll();

    public void add(Veterinario veterinario);

    public void deleteById(Long id);

    public void update(Veterinario veterinario);
}
