package com.example.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Cliente;
import com.example.demo.model.Consulta;
import com.example.demo.model.Mascota;
import com.example.demo.model.Veterinario;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MascotaRepositoryTest {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @BeforeEach
    public void setUp() {
        mascotaRepository.save(new Mascota("Luna", "Beagle", 3, 10.5f,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/1200px-Shemsu_Sotis_Perun.jpg",
                "Dermatitis"));
        mascotaRepository.save(new Mascota("Max", "Golden Retriever", 5, 25.3f,
                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09golden20retriever.jpg?itok=48StbVfe",
                "Displasia de cadera"));
        mascotaRepository.save(new Mascota("Bella", "Bulldog Francés", 4, 12.7f,
                "https://picartpetcare.com/wp-content/uploads/2020/05/BULLDOG-FRANC%C3%89S.jpg",
                "Infección respiratoria"));
        mascotaRepository.save(new Mascota("Charlie", "Labrador Retriever", 6, 30.2f,
                "https://pamipe.com/wiki/wp-content/uploads/2022/09/Labrador-Retriever.jpg",
                "Oído externo inflamado"));

        clienteRepository.save(new Cliente(123456, "Gabriel Mora",
                "morita@gmail.com", 896547));
        clienteRepository.save(new Cliente(9876543, "Eladio Carrion",
                "ela.god@gmail.com", 546791));

        // Asociar mascotas a clientes
        List<Mascota> mascotas = mascotaRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();

        int indiceMascota = 0;
        for (Cliente cliente : clientes) {
            for (int i = 0; i < 2 && indiceMascota < mascotas.size(); i++) {
                Mascota mascota = mascotas.get(indiceMascota);
                mascota.setCliente(cliente);
                mascotaRepository.save(mascota);
                indiceMascota++;
            }
        }

        veterinarioRepository.save(new Veterinario("Dr. Juan Pérez", 111111, "clave123", "Cirugía",
                "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.width-1200.format-webp.webp"));
        veterinarioRepository.save(new Veterinario("Dra. Ana Gómez", 222222, "clave234", "Medicina Interna",
                "https://www.infobae.com/new-resizer/ZnDkR1HUD3VOYyxcl1NfySwaToc=/1440x960/filters:format(webp):quality(85)/cloudfront-us-east-1.images.arcpublishing.com/infobae/L6GI2ZSXFZGADESR57UO666ZE4.jpg"));

        Mascota mascota = mascotaRepository.findById(1L).get();
        Veterinario veterinario = veterinarioRepository.findById(1L).get();

        Consulta consulta = new Consulta(new Date());
        consulta.setMascota(mascota);
        consulta.setVeterinario(veterinario);

        consultaRepository.save(consulta);

        Consulta consulta2 = new Consulta(new Date());
        consulta2.setMascota(mascotaRepository.findById(2L).get());
        consulta2.setVeterinario(veterinarioRepository.findById(2L).get());

        consultaRepository.save(consulta2);

    }

    @Test
    public void MascotaRepository_save_Mascota() {

        Mascota mascota = new Mascota("Luka", "Golden", 8, 5,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpUhiCfgS47unNyoj3f1fLzI52AY-n8mGsYw&s",
                "Gripa");

        Mascota savedMascota = mascotaRepository.save(mascota);

        Assertions.assertThat(savedMascota).isNotNull();
    }

    @Test
    public void MascotaRepository_findAll_NotEmptyList() {

        Mascota mascota = new Mascota("Luka", "Golden", 8, 5,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpUhiCfgS47unNyoj3f1fLzI52AY-n8mGsYw&s",
                "Gripa");

        Mascota mascota2 = new Mascota("Max", "Golden", 8, 5,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpUhiCfgS47unNyoj3f1fLzI52AY-n8mGsYw&s",
                "Gripa");

        mascotaRepository.save(mascota);
        mascotaRepository.save(mascota2);

        List<Mascota> mascotas = mascotaRepository.findAll();

        Assertions.assertThat(mascotas).isNotEmpty();
        Assertions.assertThat(mascotas.size()).isEqualTo(6);
        Assertions.assertThat(mascotas.size()).isGreaterThan(0);
    }

    @Test
    public void MascotaRepository_findById_FindWrongIndex() {

        Long index = -1L;

        Optional<Mascota> mascota = mascotaRepository.findById(index);

        Assertions.assertThat(mascota).isEmpty();
    }

    @Test
    public void MascotaRepository_deleteById_EmptyMascota() {

        Long index = 1L;

        mascotaRepository.deleteById(index);

        Assertions.assertThat(mascotaRepository.findById(index)).isEmpty();

    }

    @Test
    public void MascotaRepository_updateById_Mascota() {
        Long index = 1L;

        Mascota mascota = mascotaRepository.findById(index).get();

        mascota.setNombre("Toby");

        Mascota updatedMascota = mascotaRepository.save(mascota);

        Assertions.assertThat(updatedMascota).isNotNull();
        Assertions.assertThat(updatedMascota.getNombre()).isEqualTo("Toby");
    }

    @Test
    public void MascotaRepository_mascotasEnTratamiento_Int() {

        int mascotasEnTratamiento = mascotaRepository.mascotasEnTratamiento();

        Assertions.assertThat(mascotasEnTratamiento).isGreaterThan(0);
    }

    @Test
    public void MascotaRepository_findByClienteId_NotEmptyList() {

        Long index = 1L;

        List<Mascota> mascotas = mascotaRepository.findByClienteId(index);

        Assertions.assertThat(mascotas).isNotEmpty();
        Assertions.assertThat(mascotas.size()).isGreaterThan(0);
        Assertions.assertThat(mascotas.size()).isEqualTo(2);
    }

    @Test
    public void MascotaRepository_getTotalMascotas_Int() {

        long totalMascotas = mascotaRepository.getTotalMascotas();

        Assertions.assertThat(totalMascotas).isGreaterThan(0);
        Assertions.assertThat(totalMascotas).isEqualTo(4);
    }
}
