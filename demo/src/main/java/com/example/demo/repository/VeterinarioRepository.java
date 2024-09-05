package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

    Veterinario findByCedulaAndClave(int cedula, String clave);

    @Query("SELECT SUM(v.numAtenciones) FROM Veterinario v")
    int getNumAtenciones();

    @Query("SELECT v FROM Veterinario v JOIN Consulta c ON c.veterinario = v WHERE c.mascota.id = :mascotaId")
    Veterinario findVeterinarioByMascotaId(@Param("mascotaId") Long mascotaId);
}
