package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENT_TABLE")
public class Cliente {

    private String nombre;
    private int cedula;
    private int celular;
    private String email;

    @Column(name = "PK_ID")
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnoreProperties("cliente")
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas = new ArrayList<>();

    public Cliente(int cedula, String nombre, String email, int celular, Long id) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
        this.id = id;
    }

    public Cliente(int cedula, String nombre, String email, int celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
    }

    public Cliente() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
