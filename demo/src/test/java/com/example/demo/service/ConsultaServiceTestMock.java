package com.example.demo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.model.Consulta;
import com.example.demo.repository.ConsultaRepository;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ConsultaServiceTestMock {

    @InjectMocks
    private ConsultaServiceImpl consultaService;

    @Mock
    private ConsultaRepository consultaRepository;

    @BeforeEach
    public void init() {
        // Inicialización si es necesaria antes de cada prueba
    }

    // 1. Prueba para añadir una consulta
    @Test
    public void ConsultaService_addConsulta_Consulta() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.APRIL, 5);
        Date fechaConsulta = truncateTime(calendar.getTime());

        // Arrange: Crear una nueva consulta
        Consulta consulta = new Consulta(fechaConsulta);

        when(consultaRepository.save(consulta)).thenReturn(consulta);

        // Act: Llamar al método add del servicio
        consultaService.add(consulta);

        // Assert
        Assertions.assertThat(consulta).isNotNull();
        // Verify: Asegurarse de que el método save se llamó exactamente una vez
        verify(consultaRepository, times(1)).save(consulta);
    }

    // 2. Prueba para recuperar todas las consultas
    @Test
    public void ConsultaService_findAll_Consulta() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 10);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2024, Calendar.JANUARY, 8);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2024, Calendar.DECEMBER, 24);

        Date fechaEsperada = truncateTime(calendar.getTime());
        Date fechaEsperada1 = truncateTime(calendar1.getTime());
        Date fechaEsperada2 = truncateTime(calendar2.getTime());

        // Arrange
        when(consultaRepository.findAll()).thenReturn(
            List.of(
                new Consulta(fechaEsperada),
                new Consulta(fechaEsperada1),
                new Consulta(fechaEsperada2)
            )
        );

        // Act
        List<Consulta> consultas = consultaService.findAll();

        // Assert
        Assertions.assertThat(consultas).isNotNull();
        Assertions.assertThat(consultas.size()).isEqualTo(3);
    }

    // 3. Prueba para recuperar todas las consultas de una mascota
    @Test
    public void ConsultaService_findByMascotaId_Consultas() {
        // Arrange
        Long mascotaId = 1L;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MARCH, 15);
        Consulta consulta1 = new Consulta(truncateTime(calendar.getTime()));

        calendar.set(2024, Calendar.APRIL, 10);
        Consulta consulta2 = new Consulta(truncateTime(calendar.getTime()));

        when(consultaRepository.findByMascotaId(mascotaId))
                .thenReturn(List.of(consulta1, consulta2));

        // Act
        List<Consulta> consultas = consultaService.findByMascotaId(mascotaId);

        // Assert
        Assertions.assertThat(consultas).isNotNull();
        Assertions.assertThat(consultas.size()).isEqualTo(2);

        // Verify: Asegurarse de que el método del repositorio fue llamado una vez
        verify(consultaRepository, times(1)).findByMascotaId(mascotaId);
    }

    // 4. Prueba para verificar que se elimine una consulta por ID
    @Test
    public void ConsultaService_DeleteById_Consultas() {
        Long consultaId = 5L;

        // Arrange
        doNothing().when(consultaRepository).deleteById(consultaId);

        // Act
        consultaService.deleteById(consultaId);

        // Assert
        verify(consultaRepository, times(1)).deleteById(consultaId);
    }

    // 5. Prueba para verificar la actualización de una consulta
    @Test
    public void ConsultaService_update_Consultas() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 10);
        Date fechaConsulta = calendar.getTime();

        // Arrange
        Consulta consulta = new Consulta(fechaConsulta);
        consulta.setId(1L); 

        when(consultaRepository.existsById(1L)).thenReturn(true);
        when(consultaRepository.save(consulta)).thenReturn(consulta);

        // Act
        consultaService.update(consulta);

        // Assert
        Assertions.assertThat(consulta).isNotNull();
        verify(consultaRepository, times(1)).save(consulta);
        verify(consultaRepository, times(1)).existsById(1L);
    }

    // 6. Prueba para encontrar una consultas por id 
    @Test
    public void shouldFindConsultaById_WithMock() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 10);
        Date fechaEsperada = truncateTime(calendar.getTime());

        Consulta consulta = new Consulta(fechaEsperada);
        consulta.setId(1L);

        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

        // Act
        Consulta retrievedConsulta = consultaService.findById(1L);

        // Assert
        Assertions.assertThat(retrievedConsulta).isNotNull();
        Assertions.assertThat(retrievedConsulta.getId()).isEqualTo(1L);
        Assertions.assertThat(truncateTime(retrievedConsulta.getFechaConsulta())).isEqualTo(fechaEsperada);
        verify(consultaRepository, times(1)).findById(1L);
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
