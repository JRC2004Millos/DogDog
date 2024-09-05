package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Consulta;

@Service
public interface ConsultaService {

    public Consulta findById(Long id);

    public Collection<Consulta> findAll();

    public void add(Consulta consulta);

    public void deleteById(Long id);

    public void update(Consulta consulta);
}
