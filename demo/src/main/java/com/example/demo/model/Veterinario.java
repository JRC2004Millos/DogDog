package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Veterinario {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private int cedula;
    private String clave;
    private String especialidad;
    private String fotoURL;
    private boolean estado;

    @JsonIgnoreProperties("veterinario")
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consulta = new ArrayList<>();

    public Veterinario(String nombre, int cedula, String clave, String especialidad, String fotoURL) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.clave = clave;
        this.especialidad = especialidad;
        this.fotoURL = fotoURL;
        this.estado = true;
    }

}
