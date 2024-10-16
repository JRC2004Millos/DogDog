package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    private int cantidad;

    @JsonIgnoreProperties("consulta")
    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @JsonIgnoreProperties("consulta")
    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @JsonIgnoreProperties("consulta")
    @ManyToOne
    @JoinColumn(name = "droga_id")
    private Droga droga;

    private Date fechaConsulta;

    public Consulta() {
    }

    public Consulta(Date fechaConsulta) {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
