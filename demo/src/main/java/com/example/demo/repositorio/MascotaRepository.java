package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Mascota;

@Repository
public class MascotaRepository {

    private Map<Integer, Mascota> mascotas = new HashMap<>();

    public MascotaRepository() {
        mascotas.put(1, new Mascota("Luna", "Beagle", 3, 10.5f,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/1200px-Shemsu_Sotis_Perun.jpg",
                false));
        mascotas.put(2, new Mascota("Max", "Golden Retriever", 5, 25.3f,
                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09golden20retriever.jpg?itok=48StbVfe",
                false));
        mascotas.put(3, new Mascota("Bella", "Poodle", 4, 8.2f,
                "https://purina.com.co/sites/default/files/2022-10/purina-brand-que-sabes-de-los-perros-poodle.jpg",
                false));
        mascotas.put(4, new Mascota("Charlie", "Bulldog", 6, 20.0f,
                "https://upload.wikimedia.org/wikipedia/commons/a/a4/Racib%C3%B3rz_2007_082.jpg", false));
        mascotas.put(5, new Mascota("Lucy", "Dachshund", 2, 7.1f,
                "https://www.akc.org/wp-content/uploads/2017/11/Longhaired-Dachshund-standing-outdoors.jpg", false));
        mascotas.put(6, new Mascota("Cooper", "Boxer", 7, 29.8f,
                "https://images.ctfassets.net/denf86kkcx7r/cfiQGTrKSKyg6sOFNXWjz/3935effb717f6d1bb255c80813ee74cc/boxer_seguro_perro_santevet-56?fm=webp&w=612",
                false));
        mascotas.put(7, new Mascota("Daisy", "Shih Tzu", 5, 6.3f,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRN6Ul9KehKdD7lzzGS90l7nyXattlnZcrMug&s", false));
        mascotas.put(8, new Mascota("Rocky", "Pastor Alemán", 4, 30.2f,
                "https://www.akc.org/wp-content/uploads/2017/11/German-Shepherd-on-White-00.jpg", false));
        mascotas.put(9, new Mascota("Molly", "Yorkshire Terrier", 3, 4.9f,
                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09Yorkshire20Terrier.jpg?itok=MQRiTY3f",
                false));
        mascotas.put(10, new Mascota("Toby", "Labrador Retriever", 6, 27.5f,
                "https://upload.wikimedia.org/wikipedia/commons/0/04/Labrador_Retriever_%281210559%29.jpg", false));
        mascotas.put(11, new Mascota("Sadie", "Cocker Spaniel", 2, 10.1f,
                "https://i0.wp.com/mascotassaintdaniel.com/wp-content/uploads/2022/11/cachorro_cocker_spaniel_crop1628715561051.jpeg_1753094345.webp?fit=1024%2C1024&ssl=1",
                false));
        mascotas.put(12, new Mascota("Buddy", "Siberian Husky", 5, 24.4f,
                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-08Siberian20Husky2.jpg?itok=d5njFuxB",
                false));
        mascotas.put(13, new Mascota("Chloe", "Chihuahua", 3, 2.8f,
                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Chihuahua-Smooth-Coat.jpg?itok=L2PWsV9_",
                false));
        mascotas.put(14, new Mascota("Bailey", "Australian Shepherd", 4, 22.9f,
                "https://www.akc.org/wp-content/uploads/2017/11/Australian-Shepherd.1.jpg", false));
        mascotas.put(15, new Mascota("Roxy", "Bulldog Francés", 6, 11.2f,
                "https://www.zooplus.es/magazine/wp-content/uploads/2019/06/franz%C3%B6sische-bulldogge-1024x683.jpg",
                false));
        mascotas.put(16, new Mascota("Bear", "Gran Danés", 7, 45.3f,
                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/deutsche-dogge.jpg", false));
        mascotas.put(17, new Mascota("Sophie", "Pug", 5, 8.7f,
                "https://upload.wikimedia.org/wikipedia/commons/f/fe/My_pug.jpg",
                false));
        mascotas.put(18, new Mascota("Jack", "Rottweiler", 4, 35.0f,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/02_I_Exposici%C3%B3n_Monogr%C3%A1fica_Club_Rottweiler_de_Espa%C3%B1a_-_Santa_Brigida_-_Gran_Canaria.jpg/640px-02_I_Exposici%C3%B3n_Monogr%C3%A1fica_Club_Rottweiler_de_Espa%C3%B1a_-_Santa_Brigida_-_Gran_Canaria.jpg",
                false));
        mascotas.put(19, new Mascota("Zoe", "Border Collie", 3, 18.5f,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/800px-Border_collie_canon.jpg",
                false));
        mascotas.put(20, new Mascota("Duke", "Doberman", 6, 40.1f,
                "https://mascooriente.co/wp-content/uploads/2020/11/doberman.jpg", false));
    }

    public Mascota findById(int id) {
        return mascotas.get(id);
    }

    public Collection<Mascota> findAll() {
        return mascotas.values();
    }
}