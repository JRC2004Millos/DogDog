package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;
import com.example.demo.repositorio.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Mascota> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Mascota> findByDuenoId(int duenoId) {
        return repo.findByDuenoId(duenoId);
    }

    @Override
    public void add(Mascota mascota) {
        repo.add(mascota);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Mascota mascota) {
        repo.update(mascota);
    }
}
