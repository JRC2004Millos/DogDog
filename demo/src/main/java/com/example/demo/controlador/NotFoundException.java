package com.example.demo.controlador;

public class NotFoundException extends RuntimeException {
    private Long id;

    public NotFoundException(Long identificacion) {
        this.id = identificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}