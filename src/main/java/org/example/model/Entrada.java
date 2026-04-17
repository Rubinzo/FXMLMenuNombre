package org.example.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Entrada {
    private String nombre;
    private int precio;
    private String local;
    private int id;

    public Entrada(String nombre, int precio, String local) {
        this.nombre = nombre;
        this.precio = precio;
        this.local = local;
    }

    public Entrada(String nombre, int precio, String local, int id) {
        this.nombre = nombre;
        this.precio = precio;
        this.local = local;
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int edad) {
        this.precio = edad;
    }


    @Override
    public String toString() {
        return String.format("Nombre: %s, Precio: %d, Local: %s", this.nombre, this.precio, this.local);
    }
}
