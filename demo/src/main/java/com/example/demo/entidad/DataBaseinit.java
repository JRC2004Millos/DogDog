package com.example.demo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DataBaseinit implements ApplicationRunner{

    @Autowired
    ClienteRepository client_repo;

    @Autowired
    MascotaRepository mascota_repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        client_repo.save(new Cliente(123456, "Gabriel Mora", "morita@gmail.com", 896547));
        client_repo.save(new Cliente(9876543, "Eladio Carrion", "ela.god@gmail.com", 546791));
        client_repo.save(new Cliente(753124, "Benito Antonio", "BadBunny@gmail.com", 749685));
        client_repo.save(new Cliente(741258, "Diomedes Diaz", "diomedesdays@gmail.com", 349761));
        client_repo.save(new Cliente(852123, "Kaleth Morales", "KaLimbo@gmail.com", 412398));
        client_repo.save(new Cliente(6523987, "Silvestre Dangond", "WinniePooh@gmail.com", 987201));
        client_repo.save(new Cliente(12345678, "Henry Cavil","cavilHenry@gmail.com", 321567885));

        mascota_repo.save(new Mascota("Luna", "Beagle", 3, 10.5f,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/1200px-Shemsu_Sotis_Perun.jpg"));
        mascota_repo.save(new Mascota("Max", "Golden Retriever", 5, 25.3f,
        "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09golden20retriever.jpg?itok=48StbVfe"));

        //Asociar mascotas a cliente
        Cliente asociar = client_repo.findById(1L).get();
        for (Mascota m : mascota_repo.findAll()) {
            m.setCliente(asociar);
            mascota_repo.save(m);
        }
    }
}
