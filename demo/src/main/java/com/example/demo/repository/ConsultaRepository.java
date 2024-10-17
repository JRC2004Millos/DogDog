package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByMascotaId(Long mascotaId);

    @Query("SELECT COUNT(c) FROM Consulta c WHERE c.fechaConsulta >= :inicio AND c.fechaConsulta <= :fin")
    Long countTratamientosUltimoMes(@Param("inicio") Date inicio, @Param("fin") Date fin);

    @Query("SELECT d.nombre, SUM(c.cantidad) FROM Consulta c " +
       "JOIN c.droga d " +
       "WHERE c.fechaConsulta >= :inicio AND c.fechaConsulta <= :fin " +
       "GROUP BY d.nombre")
    List<Object[]> getCantidadTratamientosPorDroga(Date inicio, Date fin);

}
