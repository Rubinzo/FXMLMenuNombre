package org.example.dao;

import org.example.model.Producto;

import java.util.List;

public interface ProductoDAO {

    void guardar(Producto producto);
    List<Producto> cargar();
}
