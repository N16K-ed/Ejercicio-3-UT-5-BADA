package org.example.articulos;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
    private String nombre;
    private double precio;
    private String descripcion;
    private List<Etiquetas> etiquetas;

    public Articulo (String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.etiquetas = new ArrayList<>();
    }


    public List<Etiquetas> getEtiquetas() {
        return etiquetas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEtiquetas(List<Etiquetas> etiquetas) {
        this.etiquetas = etiquetas;
    }
}