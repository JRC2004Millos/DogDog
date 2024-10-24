package com.example.demo.controller;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.model.Mascota;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = MascotaController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class MascotaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MascotaService mascotaService;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void MascotaController_agregarMascota_Mascota() throws Exception {
        Mascota mascota = new Mascota("Toby", "Golden", 8, 5,
                "https://encrypted-tbn0.gstatic.com?q=tbn:ANd9GcRpUCfgSUNNyoj3f1fLzI52AY-n8mYw&s", "Gripa");

        when(mascotaService.add(Mockito.any(Mascota.class))).thenReturn(mascota);

        ResultActions response = mockMvc.perform(
                post("/mascotas/agregar")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(mascota)));

        response.andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nombre").value(mascota.getNombre()))
                .andExpect(jsonPath("$.raza").value(mascota.getRaza()))
                .andExpect(jsonPath("$.edad").value(mascota.getEdad()))
                .andExpect(jsonPath("$.peso").value(mascota.getPeso()))
                .andExpect(jsonPath("$.fotoURL").value(mascota.getFotoURL()))
                .andExpect(jsonPath("$.enfermedad").value(mascota.getEnfermedad()));
    }

}
