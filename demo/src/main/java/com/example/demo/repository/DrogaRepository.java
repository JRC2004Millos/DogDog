package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Droga;

@Repository
public interface DrogaRepository extends JpaRepository<Droga, Long> {
    
}
