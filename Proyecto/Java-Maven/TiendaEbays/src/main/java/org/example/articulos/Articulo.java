package org.example.articulos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Articulo {
    private String nombre;
    private double precio;
    private String descripcion;
    private List<Etiquetas> etiquetas;
    private int existencias;
    private Date fechaPublicacion;;

    public Articulo (String nombre, double precio, String descripcion, int existencias) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.etiquetas = new ArrayList<>();
        this.existencias = existencias;
        this.fechaPublicacion = new Date();
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

    public int getExistencias() {
        return existencias;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setEtiquetas(List<Etiquetas> etiquetas) {
        this.etiquetas = etiquetas;
    }
}