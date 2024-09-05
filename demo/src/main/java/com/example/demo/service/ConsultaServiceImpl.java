package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Consulta;
import com.example.demo.repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public Consulta findById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    @Override
    public void add(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    @Override
    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public void update(Consulta consulta) {
        if (consulta.getId() != null && consultaRepository.existsById(consulta.getId())) {
            consultaRepository.save(consulta);
        }
    }
}
