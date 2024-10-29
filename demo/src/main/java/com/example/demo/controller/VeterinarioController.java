package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.VeterinarioDTO;
import com.example.demo.DTOs.VeterinarioMapper;
import com.example.demo.model.Cliente;
import com.example.demo.model.UserEntity;
import com.example.demo.model.Veterinario;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.VeterinarioService;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin("http://localhost:4200")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTGenerator jwtGenerator;

    // http://localhost:8080/veterinario/{id}
    @GetMapping("/{id}")
    public Veterinario home(@PathVariable("id") Long id) {
        return veterinarioService.findById(id);
    }

    // CRUD VETERINARIO -> Pasar a JSON para entrega 9

    @GetMapping("/ver")
    public List<Veterinario> mostrarVeterinarios() {
        return veterinarioService.findAll();
    }

    // http://localhost:8080/veterinario/id}
    @GetMapping("/cedula/{cedula}")
    public Veterinario mostrarClienteByCedula(@PathVariable("cedula") int cedula) {
        return veterinarioService.findByCedula(cedula);
    }

    @GetMapping("/details")
    public ResponseEntity<VeterinarioDTO> buscarEstudianteEntity() {
        Veterinario veterinario = veterinarioService.findByCedula(Integer.parseInt(
                SecurityContextHolder.getContext().getAuthentication().getName()));

        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);

        if (veterinario == null) {
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
    }

    // http://localhost:8080/veterinario/agregar
    @GetMapping("/agregar")
    public String agregar(Model model) {
        Veterinario veterinario = new Veterinario("", 0, "", "", "");

        model.addAttribute("veterinario", veterinario);

        return "agregar_vet";
    }

    @PostMapping("/login")
    public ResponseEntity loginVeterinarioEntity(@RequestBody Veterinario veterinario) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(veterinario.getCedula(), veterinario.getClave()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    // http://localhost:8080/veterinario/agregar
    @PostMapping("/agregar")
    public ResponseEntity agregar(@RequestBody Veterinario veterinario) {
        // Veterinario newVet = veterinarioService.add(veterinario);
        // VeterinarioDTO vetDTO = VeterinarioMapper.INSTANCE.convert(newVet);
        // if (veterinario == null) {
        // return new ResponseEntity<VeterinarioDTO>(vetDTO, HttpStatus.BAD_REQUEST);
        // }

        // return new ResponseEntity<VeterinarioDTO>(vetDTO, HttpStatus.OK);

        if (userRepository.existsByUsername(String.valueOf(veterinario.getCedula()))) {
            return new ResponseEntity<String>("Este veterinario ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.VetToUser(veterinario);
        veterinario.setUser(userEntity);
        Veterinario vetDB = veterinarioService.add(veterinario);
        VeterinarioDTO newVet = VeterinarioMapper.INSTANCE.convert(vetDB);
        if (newVet == null) {
            return new ResponseEntity<VeterinarioDTO>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<VeterinarioDTO>(newVet, HttpStatus.CREATED);

    }

    // http://localhost:8080/veterinario/modificar/{id}
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("veterinario", veterinarioService.findById(id));
        return "modificar_vet";
    }

    // http://localhost:8080/veterinario/modificar/{id}
    @PutMapping("/modificar")
    public void modificar(@RequestBody Veterinario veterinario) {
        Veterinario original = veterinarioService.findById(veterinario.getId());
        veterinario.setConsulta(original.getConsulta());
        veterinarioService.update(veterinario);
    }

    // http://localhost:8080/veterinario/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
    }

    // http://localhost:8080/veterinario/activosInactivos
    @GetMapping("/activosInactivos")
    public Map<String, Integer> getActivosInactivos() {
        Map<String, Integer> response = new HashMap<>();
        response.put("activos", veterinarioService.countByEstado(true));
        response.put("inactivos", veterinarioService.countByEstado(false));
        return response;
    }
}
