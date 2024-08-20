package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Mascota;

@Repository
public class MascotaRepository {

        private Map<Integer, Mascota> mascotas = new HashMap<>();

        public MascotaRepository() {
                mascotas.put(1, new Mascota(1, "Luna", "Beagle", 3, 10.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/1200px-Shemsu_Sotis_Perun.jpg",
                                1));
                mascotas.put(2, new Mascota(2, "Max", "Golden Retriever", 5, 25.3f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09golden20retriever.jpg?itok=48StbVfe",
                                2));
                mascotas.put(3, new Mascota(3, "Bella", "Poodle", 4, 8.2f,
                                "https://purina.com.co/sites/default/files/2022-10/purina-brand-que-sabes-de-los-perros-poodle.jpg",
                                3));
                mascotas.put(4, new Mascota(4, "Charlie", "Bulldog", 6, 20.0f,
                                "https://upload.wikimedia.org/wikipedia/commons/a/a4/Racib%C3%B3rz_2007_082.jpg",
                                4));
                mascotas.put(5, new Mascota(5, "Lucy", "Dachshund", 2, 7.1f,
                                "https://www.akc.org/wp-content/uploads/2017/11/Longhaired-Dachshund-standing-outdoors.jpg",
                                5));
                mascotas.put(6, new Mascota(6, "Cooper", "Boxer", 7, 29.8f,
                                "https://images.ctfassets.net/denf86kkcx7r/cfiQGTrKSKyg6sOFNXWjz/3935effb717f6d1bb255c80813ee74cc/boxer_seguro_perro_santevet-56?fm=webp&w=612",
                                6));
                mascotas.put(7, new Mascota(7, "Daisy", "Shih Tzu", 5, 6.3f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRN6Ul9KehKdD7lzzGS90l7nyXattlnZcrMug&s",
                                7));
                mascotas.put(8, new Mascota(8, "Rocky", "Pastor Alemán", 4, 30.2f,
                                "https://www.akc.org/wp-content/uploads/2017/11/German-Shepherd-on-White-00.jpg",
                                8));
                mascotas.put(9, new Mascota(9, "Molly", "Yorkshire Terrier", 3, 4.9f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09Yorkshire20Terrier.jpg?itok=MQRiTY3f",
                                9));
                mascotas.put(10, new Mascota(10, "Toby", "Labrador Retriever", 6, 27.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/0/04/Labrador_Retriever_%281210559%29.jpg",
                                10));
                mascotas.put(11, new Mascota(11, "Sadie", "Cocker Spaniel", 2, 10.1f,
                                "https://i0.wp.com/mascotassaintdaniel.com/wp-content/uploads/2022/11/cachorro_cocker_spaniel_crop1628715561051.jpeg_1753094345.webp?fit=1024%2C1024&ssl=1",
                                1));
                mascotas.put(12, new Mascota(12, "Buddy", "Siberian Husky", 5, 24.4f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-08Siberian20Husky2.jpg?itok=d5njFuxB",
                                2));
                mascotas.put(13, new Mascota(13, "Chloe", "Chihuahua", 3, 2.8f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Chihuahua-Smooth-Coat.jpg?itok=L2PWsV9_",
                                3));
                mascotas.put(14, new Mascota(14, "Bailey", "Australian Shepherd", 4, 22.9f,
                                "https://www.akc.org/wp-content/uploads/2017/11/Australian-Shepherd.1.jpg", 4));
                mascotas.put(15, new Mascota(15, "Roxy", "Bulldog Francés", 6, 11.2f,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2019/06/franz%C3%B6sische-bulldogge-1024x683.jpg",
                                5));
                mascotas.put(16, new Mascota(16, "Bear", "Gran Danés", 7, 45.3f,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/deutsche-dogge.jpg",
                                6));
                mascotas.put(17, new Mascota(17, "Sophie", "Pug", 5, 8.7f,
                                "https://upload.wikimedia.org/wikipedia/commons/f/fe/My_pug.jpg",
                                7));
                mascotas.put(18, new Mascota(18, "Jack", "Rottweiler", 4, 35.0f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/02_I_Exposici%C3%B3n_Monogr%C3%A1fica_Club_Rottweiler_de_Espa%C3%B1a_-_Santa_Brigida_-_Gran_Canaria.jpg/640px-02_I_Exposici%C3%B3n_Monogr%C3%A1fica_Club_Rottweiler_de_Espa%C3%B1a_-_Santa_Brigida_-_Gran_Canaria.jpg",
                                8));
                mascotas.put(19, new Mascota(19, "Zoe", "Border Collie", 3, 18.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/800px-Border_collie_canon.jpg",
                                9));
                mascotas.put(20, new Mascota(20, "Duke", "Doberman", 6, 40.1f,
                                "https://mascooriente.co/wp-content/uploads/2020/11/doberman.jpg", 10));
        }

        public Mascota findById(int id) {
                return mascotas.get(id);
        }

        public Collection<Mascota> findAll() {
                return mascotas.values();
        }

        public Collection<Mascota> findByDuenoId(int id) {
                return mascotas.values().stream().filter(mascota -> mascota.getIdDueno() == id)
                                .collect(Collectors.toList());
        }

        public void add(Mascota mascota) {
                int tam = mascotas.size();
                int lastId = mascotas.get(tam).getId();
                mascota.setId(lastId + 1);

                mascotas.put(mascota.getId(), mascota);
        }

        public void deleteById(int id) {
                mascotas.remove(id);
        }

        public void update(Mascota mascota) {
                mascotas.put(mascota.getId(), mascota);
        }
}