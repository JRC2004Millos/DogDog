package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mascota;

@Service
public interface MascotaService {

    public Mascota findById(Long id);

    public List<Mascota> findAll();

    public List<Mascota> findByDuenoId(Long clienteId);

    public void add(Mascota mascota);

    public void deleteById(Long id);

    public void update(Mascota mascota);

    public int mascotasEnTratamiento();

}