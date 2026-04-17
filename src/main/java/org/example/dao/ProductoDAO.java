package org.example.dao;

import org.example.model.Entrada;

import java.util.List;

public interface ProductoDAO {

    void guardar(Entrada entrada);
    List<Entrada> cargar();
}
