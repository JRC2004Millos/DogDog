package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Consulta;
import com.example.demo.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
@CrossOrigin("http://localhost:4200")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/ver")
    public ResponseEntity<List<Consulta>> verConsultas() {

        List<Consulta> consultas = consultaService.findAll();

        ResponseEntity<List<Consulta>> response = new ResponseEntity<>(consultas, HttpStatus.OK);
        return response;
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Consulta> verConsulta(@PathVariable Long id) {
        Consulta consulta = consultaService.findById(id);
        if (consulta == null) {
            return new ResponseEntity<Consulta>(consulta, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Consulta>(consulta, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public void agregar(@RequestBody Consulta consulta) {
        consultaService.add(consulta);

    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id) {
        consultaService.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.NO_CONTENT);

    }

    @PutMapping("/modificar")
    public ResponseEntity<Consulta> modificar(@RequestBody Consulta consulta) {
        consultaService.update(consulta);

        return new ResponseEntity<>(consulta, HttpStatus.OK);
    }

    @GetMapping("/mascota/{mascotaId}")
    public List<Consulta> getConsultasByMascota(@PathVariable Long mascotaId) {
        return consultaService.findByMascotaId(mascotaId);
    }

    // localhost:8080/consultas/ultimoMes
    @GetMapping("/ultimoMes")
    public ResponseEntity<Long> getTratamientosUltimoMes() {
        Long total = consultaService.getTratamientosUltimoMes();
        return ResponseEntity.ok(total);
    }

    // localhost:8080/consultas/tratamientos-por-droga
    @GetMapping("/tratamientos-por-droga")
    public ResponseEntity<List<Object[]>> getCantidadTratamientosPorDroga() {
        List<Object[]> tratamientos = consultaService.getCantidadTratamientosPorDrogaUltimoMes();
        return ResponseEntity.ok(tratamientos);
    }

}
