package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Droga;
import com.example.demo.repository.DrogaRepository;

@Service
public class DrogaServiceImpl implements DrogaService {

    @Autowired
    private DrogaRepository drogaRepository;

    @Override
    public Droga findById(Long id) {
        return drogaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Droga> findAll() {
        return drogaRepository.findAll();
    }

    @Override
    public void add(Droga droga) {
        drogaRepository.save(droga);
    }

    @Override
    public void deleteById(Long id) {
        drogaRepository.deleteById(id);
    }

    @Override
    public void update(Droga droga) {
        if (droga.getId() != null && drogaRepository.existsById(droga.getId())) {
            drogaRepository.save(droga);
        }
    }

    @Override
    public Double getVentasTotales() {
        return drogaRepository.getVentasTotales();
    }

    @Override
    public Double getGananciasTotales() {
        return drogaRepository.getGananciasTotales();
    }

    @Override
    public List<Object[]> getTopTratamientos() {
        return drogaRepository.findTopByUnidadesVendidas();
    }

}