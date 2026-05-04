package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.model.Producto;
import org.example.service.ProductoService;

public class FormularioController {

    private final ProductoService service = new ProductoService();


    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;
    @FXML
    private ListView<Producto> listaEntradas;

    private ObservableList<Producto> productos = FXCollections.observableArrayList();


    @FXML
    private void initialize() {

        service.getEntradas();
        listaEntradas.setItems(productos);

        listaEntradas.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                Producto productoSeleccionada = listaEntradas.getSelectionModel().getSelectedItem();
                if (productoSeleccionada != null) {
                    productos.remove(productoSeleccionada);
                }
            }
        });

    }


    public void accionBoton(){
        String nombre = txtNombre.getText();
        Double precio = Double.parseDouble(txtPrecio.getText());

        int stock = Integer.parseInt(txtStock.getText());

        if (!nombre.isEmpty() && !txtPrecio.getText().isEmpty() && !txtStock.getText().isEmpty()) {
            Producto producto = new Producto(nombre, precio, stock);
            productos.add(producto);

            txtNombre.clear();
            txtPrecio.clear();
            txtStock.clear();
            service.registrar(producto);
        }
    }

}
