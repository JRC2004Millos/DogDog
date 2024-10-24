package com.example.demo.controller;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Consulta;
import com.example.demo.service.ConsultaService;

@WebMvcTest(controllers = ConsultaController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultaService consultaService;

    @Test
    public void ConsultaController_agregarConsulta_Consulta() {

        Consulta consulta = new Consulta(new Date());
    }
}
