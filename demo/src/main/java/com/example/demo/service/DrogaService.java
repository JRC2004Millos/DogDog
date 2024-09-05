package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Droga;

@Service
public interface DrogaService {

    public Droga findById(Long id);

    public Collection<Droga> findAll();

    public void add(Droga droga);

    public void deleteById(Long id);

    public void update(Droga droga);
}