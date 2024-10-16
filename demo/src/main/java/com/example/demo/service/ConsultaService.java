package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Consulta;

@Service
public interface ConsultaService {

    public Consulta findById(Long id);

    public List<Consulta> findAll();

    public void add(Consulta consulta);

    public void deleteById(Long id);

    public void update(Consulta consulta);

    public List<Consulta> findByMascotaId(Long mascotaId);
}
