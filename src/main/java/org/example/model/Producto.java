package org.example.model;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private int id;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String nombre, double precio, int stock, int id) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
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




    @Override
    public String toString() {
        return String.format("Nombre: %s, Precio: %d, Local: %s", this.nombre, this.precio, this.stock);
    }
}
