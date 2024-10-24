package com.example.demo.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Droga;

@DataJpaTest
@RunWith(SpringRunner.class)
public class DrogaRepositoryTest {

    @Autowired
    private DrogaRepository drogaRepository;

    @BeforeEach
    public void setUp() {
        drogaRepository.save(new Droga("Acetaminofen", 50, 30, 5, 2));
        drogaRepository.save(new Droga("Aspirina", 70, 40, 2, 3));
        drogaRepository.save(new Droga("Paracetamol", 60, 50, 3, 4));
        drogaRepository.save(new Droga("Diphenhydramine", 90, 70, 1, 5));

    }

    @Test
    public void DrogaRepository_getVentasTotales_Double() {

        Double ventasTotales = drogaRepository.getVentasTotales();

        Assertions.assertThat(ventasTotales).isGreaterThan(0);
    }

    @Test
    public void DrogaRepository_getGananciasTotales_Double() {

        Double gananciaTotales = drogaRepository.getGananciasTotales();

        Assertions.assertThat(gananciaTotales).isGreaterThan(0);
    }

    @Test
    public void DrogaRepository_findTopByUnidadesVendidas_NotEmptyList() {
        List<Object[]> topByUnidadesVendidas = drogaRepository.findTopByUnidadesVendidas();

        Assertions.assertThat(topByUnidadesVendidas).isNotEmpty();
    }

}
