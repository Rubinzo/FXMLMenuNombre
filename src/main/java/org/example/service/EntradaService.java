package org.example.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.dao.ProductoDAO;
import org.example.dao.impl.ProductoDAOImpl;
import org.example.model.Entrada;

public class EntradaService {
    private final ProductoDAO productoDAO;

    public EntradaService() {
        productoDAO = new ProductoDAOImpl();
    }

    public void registrar(Entrada entrada) {
        productoDAO.guardar(entrada);
    }

    public ObservableList<Entrada> getEntradas() {
        return FXCollections.observableArrayList(productoDAO.cargar());
    }

}
