package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.model.Entrada;
import org.example.service.EntradaService;

public class FormularioController {

    private final EntradaService service = new EntradaService();


    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtLocal;
    @FXML
    private ListView<Entrada> listaEntradas;

    private ObservableList<Entrada> entradas = FXCollections.observableArrayList();


    @FXML
    private void initialize() {

        service.getEntradas();
        listaEntradas.setItems(entradas);

        listaEntradas.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                Entrada entradaSeleccionada = listaEntradas.getSelectionModel().getSelectedItem();
                if (entradaSeleccionada != null) {
                    entradas.remove(entradaSeleccionada);
                }
            }
        });

    }


    public void accionBoton(){
        String nombre = txtNombre.getText();
        int precio = Integer.parseInt(txtPrecio.getText());

        String local = txtNombre.getText();

        if (!nombre.isEmpty() && !txtPrecio.getText().isEmpty() && !local.isEmpty()){
            Entrada entrada = new Entrada(nombre, precio, local);
            entradas.add(entrada);

            txtNombre.clear();
            txtPrecio.clear();
            txtLocal.clear();
            service.registrar(entrada);
        }
    }

}
