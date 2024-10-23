package com.example.demo.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Mascota;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MascotaRepositoryTest {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Test
    public void MascotaRepository_save_Mascota() {

        Mascota mascota = new Mascota("Luka", "Golden", 8, 5,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpUhiCfgS47unNyoj3f1fLzI52AY-n8mGsYw&s",
                "Gripa");

        Mascota savedMascota = mascotaRepository.save(mascota);

        Assertions.assertThat(savedMascota).isNotNull();
    }

}
