package org.example.articulos;

import java.util.List;

public class Articulo {
    private String nombre;
    private double precio;
    private String descripcion;

    private List<Etiquetas> etiquetas;

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

}