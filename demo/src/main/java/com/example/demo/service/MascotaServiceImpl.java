package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Mascota> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Mascota> findByDuenoId(Long clienteId) {
        return repo.findByClienteId(clienteId);
    }

    @Override
    public Mascota add(Mascota mascota) {
        repo.save(mascota);
        return mascota;
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Mascota update(Mascota mascota) {
        return repo.save(mascota); // Retorna la mascota actualizada
    }

    @Override
    public int mascotasEnTratamiento() {
        return repo.mascotasEnTratamiento();
    }

    @Override
    public long getTotalMascotas() {
        return repo.getTotalMascotas();
    }

}
