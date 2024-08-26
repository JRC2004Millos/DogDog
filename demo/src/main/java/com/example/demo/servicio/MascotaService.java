package com.example.demo.servicio;

import java.util.Collection;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;

@Service
public interface MascotaService {

    public Mascota findById(Long id);

    public Collection<Mascota> findAll();

    public List<Mascota> findByDuenoId(Long clienteId);

    public void add(Mascota mascota);

    public void deleteById(Long id);

    public void update(Mascota mascota);

}