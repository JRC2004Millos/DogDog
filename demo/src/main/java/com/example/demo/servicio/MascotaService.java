package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;

@Service
public interface MascotaService {

    public Mascota findById(int id);

    public Collection<Mascota> findAll();

    public Collection<Mascota> findByDuenoId(int duenoId);

    public void add(Mascota mascota);

    public void deleteById(int id);

    public void update(Mascota mascota);

}