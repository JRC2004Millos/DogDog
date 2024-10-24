package com.example.demo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.model.Consulta;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ConsultaServiceTestNaive {

    @Autowired
    private ConsultaService consultaService;

    @BeforeEach
    public void init() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 10);
        Date fechaEsperada = truncateTime(calendar.getTime());

        // Inicializa las consultas de prueba
        Consulta consulta = new Consulta(fechaEsperada);
        Consulta consulta2 = new Consulta(fechaEsperada);

        consultaService.add(consulta);
        consultaService.add(consulta2);
    }

    // 1. Prueba para crear una consulta
    @Test
    public void ConsultaService_addConsulta_Consulta() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JULY, 30);
        Date fechaEsperada = truncateTime(calendar.getTime());

        // Arrange
        Consulta consulta = new Consulta(fechaEsperada);

        // Act
        consultaService.add(consulta);

        // Assert
        Assertions.assertThat(consulta).isNotNull();
        Assertions.assertThat(truncateTime(consulta.getFechaConsulta())).isEqualTo(fechaEsperada);
    }

    // 2. Prueba para recuperar todas las consultas
    @Test
    public void ConsultaService_findAll_Consulta() {
        // Act
        List<Consulta> consultas = consultaService.findAll();

        // Assert
        Assertions.assertThat(consultas).isNotNull();
        Assertions.assertThat(consultas.size()).isEqualTo(2); // Porque en el init se añaden 2 consultas
    }

    // 3. Prueba para verificar que se encuentre una consulta por su id
    @Test
    public void ConsultaService_findById_Consultas() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 10);
        Date fechaEsperada = truncateTime(calendar.getTime());

        // Arrange
        Consulta consulta = new Consulta(fechaEsperada);
        consultaService.add(consulta);

        // Act
        Consulta retrievedConsulta = consultaService.findById(consulta.getId());

        // Assert
        Assertions.assertThat(retrievedConsulta).isNotNull();
        Assertions.assertThat(truncateTime(retrievedConsulta.getFechaConsulta())).isEqualTo(fechaEsperada);
    }

    // Método auxiliar para truncar la hora de una fecha
    private Date truncateTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
