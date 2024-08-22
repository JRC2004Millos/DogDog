package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Cliente;

@Repository
public class ClienteRepository {

    private Map<Integer, Cliente> clientes = new HashMap<>();

    public ClienteRepository() {
        clientes.put(1, new Cliente(123456, "Gabriel Mora", "morita@gmail.com", 896547, 1));
        clientes.put(2, new Cliente(9876543, "Eladio Carrion", "ela.god@gmail.com", 546791, 2));
        clientes.put(3, new Cliente(753124, "Benito Antonio", "BadBunny@gmail.com", 749685, 3));
        clientes.put(4, new Cliente(741258, "Diomedes Diaz", "diomedesdays@gmail.com", 349761, 4));
        clientes.put(5, new Cliente(852123, "Kaleth Morales", "KaLimbo@gmail.com", 412398, 5));
        clientes.put(6, new Cliente(6523987, "Silvestre Dangond", "WinniePooh@gmail.com", 987201, 6));
    }

    public Cliente findById(int id) {
        return clientes.get(id);
    }

    public Collection<Cliente> findAll() {
        return clientes.values();
    }

    public void add(Cliente cliente) {
        int tam = clientes.size();
        int lastId = clientes.get(tam).getId();
        cliente.setId(lastId + 1);

        clientes.put(cliente.getId(), cliente);
    }

    public void deleteById(int id) {
        clientes.remove(id);
    }

    public void update(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}
