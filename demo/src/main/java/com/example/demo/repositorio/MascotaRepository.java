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
        mascotas.put(1, new Mascota("Luna", "Beagle", 3, 10.5f, "http://example.com/luna", false));
        mascotas.put(2, new Mascota("Max", "Golden Retriever", 5, 25.3f, "http://example.com/max", false));
        mascotas.put(3, new Mascota("Bella", "Poodle", 4, 8.2f, "http://example.com/bella", false));
        mascotas.put(4, new Mascota("Charlie", "Bulldog", 6, 20.0f, "http://example.com/charlie", false));
        mascotas.put(5, new Mascota("Lucy", "Dachshund", 2, 7.1f, "http://example.com/lucy", false));
        mascotas.put(6, new Mascota("Cooper", "Boxer", 7, 29.8f, "http://example.com/cooper", false));
        mascotas.put(7, new Mascota("Daisy", "Shih Tzu", 5, 6.3f, "http://example.com/daisy", false));
        mascotas.put(8, new Mascota("Rocky", "German Shepherd", 4, 30.2f, "http://example.com/rocky", false));
        mascotas.put(9, new Mascota("Molly", "Yorkshire Terrier", 3, 4.9f, "http://example.com/molly", false));
        mascotas.put(10, new Mascota("Toby", "Labrador Retriever", 6, 27.5f, "http://example.com/toby", false));
        mascotas.put(11, new Mascota("Sadie", "Cocker Spaniel", 2, 10.1f, "http://example.com/sadie", false));
        mascotas.put(12, new Mascota("Buddy", "Siberian Husky", 5, 24.4f, "http://example.com/buddy", false));
        mascotas.put(13, new Mascota("Chloe", "Chihuahua", 3, 2.8f, "http://example.com/chloe", false));
        mascotas.put(14, new Mascota("Bailey", "Australian Shepherd", 4, 22.9f, "http://example.com/bailey", false));
        mascotas.put(15, new Mascota("Roxy", "French Bulldog", 6, 11.2f, "http://example.com/roxy", false));
        mascotas.put(16, new Mascota("Bear", "Great Dane", 7, 45.3f, "http://example.com/bear", false));
        mascotas.put(17, new Mascota("Sophie", "Pug", 5, 8.7f, "http://example.com/sophie", false));
        mascotas.put(18, new Mascota("Jack", "Rottweiler", 4, 35.0f, "http://example.com/jack", false));
        mascotas.put(19, new Mascota("Zoe", "Border Collie", 3, 18.5f, "http://example.com/zoe", false));
        mascotas.put(20, new Mascota("Duke", "Doberman", 6, 40.1f, "http://example.com/duke", false));
    }

    public Mascota findById(int id) {
        return mascotas.get(id);
    }

    public Collection<Mascota> findAll() {
        return mascotas.values();
    }
}