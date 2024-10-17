package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Droga;

@Repository
public interface DrogaRepository extends JpaRepository<Droga, Long> {
    // Consulta para calcular las ventas totales
    @Query("SELECT SUM(d.precioVenta * d.unidadesVendidas) FROM Droga d")
    Double getVentasTotales();

    // Consulta para calcular las ganancias totales
    @Query("SELECT SUM((d.precioVenta - d.precioCompra) * d.unidadesVendidas) FROM Droga d")
    Double getGananciasTotales();
    
}
