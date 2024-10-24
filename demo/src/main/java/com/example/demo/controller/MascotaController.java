package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Mascota;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/ver")
    public ResponseEntity<List<Mascota>> verMascotas() {

        List<Mascota> mascotas = mascotaService.findAll();

        ResponseEntity<List<Mascota>> response = new ResponseEntity<>(mascotas, HttpStatus.OK);

        return response;
    }

    // http://localhost:8080/mascotas/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Mascota> mostrarMascota(@PathVariable("id") Long identificacion) {

        Mascota mascota = mascotaService.findById(identificacion);

        if (mascota == null) {
            return new ResponseEntity<Mascota>(mascota, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Mascota>(mascota, HttpStatus.OK);
    }

    // http://localhost:8080/mascotas/agregar
    @GetMapping("/agregar")
    public String agregarMascota(Model model, @ModelAttribute("veterinarioId") Long veterinarioId) {
        model.addAttribute("veterinarioId", veterinarioId);
        Mascota mascota = new Mascota("", "", 0, 0, "", "");
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "agregar_mascota";
    }

    @PostMapping("/agregar")
    public ResponseEntity<Mascota> agregarMascotaForm(@RequestBody Mascota mascota) {

        Mascota mascotaNueva = mascotaService.add(mascota);

        if (mascotaNueva == null) {
            return new ResponseEntity<Mascota>(mascotaNueva, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Mascota>(mascotaNueva, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable("id") Long identificacion) {
        mascotaService.deleteById(identificacion);
        return new ResponseEntity<>("DELETED", HttpStatus.NO_CONTENT);
    }

    // http://localhost:8080/mascotas/modificar/{id}
    @GetMapping("/modificar/{id}")
    public String modificarMascota(Model model, @PathVariable("id") Long identificacion) {
        Mascota mascota = mascotaService.findById(identificacion);
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "modificar_mascota";
    }

    @PutMapping("/modificar")
    public ResponseEntity<Mascota> modificarMascota(@RequestBody Mascota mascota) {
        mascotaService.update(mascota);

        return new ResponseEntity<>(mascota, HttpStatus.OK);
    }

    // http://localhost:8080/mascotas/total
    @GetMapping("/total")
    public ResponseEntity<Long> getTotalMascotas() {
        long total = mascotaService.getTotalMascotas();
        return ResponseEntity.ok(total);
    }

    // http://localhost:8080/mascotas/en-tratamiento
    @GetMapping("/en-tratamiento")
    public ResponseEntity<Long> mascotasEnTratamiento() {
        long totalEnTratamiento = mascotaService.mascotasEnTratamiento();
        return ResponseEntity.ok(totalEnTratamiento);
    }
}
