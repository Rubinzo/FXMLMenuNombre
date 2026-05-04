package org.example.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.dao.ProductoDAO;
import org.example.dao.impl.ProductoDAOImpl;
import org.example.model.Producto;

public class ProductoService {
    private final ProductoDAO productoDAO;

    public ProductoService() {
        productoDAO = new ProductoDAOImpl();
    }

    public void registrar(Producto producto) {
        productoDAO.guardar(producto);
    }

    public ObservableList<Producto> getEntradas() {
        return FXCollections.observableArrayList(productoDAO.cargar());
    }

}
