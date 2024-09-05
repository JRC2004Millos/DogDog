package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "veterinario_id", nullable = true)
    private Veterinario veterinario;

    @ManyToOne(optional = true)
    @JoinColumn(name = "mascota_id", nullable = true)
    private Mascota mascota;    

    @ManyToOne(optional = true)
    @JoinColumn(name = "droga_id", nullable = true)
    private Droga droga;


    private Date fechaConsulta;


    public Consulta() {
    }

    public Consulta(Date fechaConsulta){
        this.fechaConsulta = fechaConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }
    
    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }
    
    public Mascota getMascota() {
        return mascota;
    }
    
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Droga getDroga() {
        return droga;
    }
    
    public void setDroga(Droga droga) {
        this.droga = droga;
    }
}
