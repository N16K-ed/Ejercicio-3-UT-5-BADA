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
    private Date fechaPublicacion;
    private int idArticulo;

    public Articulo (String nombre, double precio, String descripcion, int existencias) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.etiquetas = new ArrayList<>();
        this.existencias = existencias;
        this.fechaPublicacion = new Date();
    }
    public Articulo (String nombre, double precio, String descripcion, int existencias, Date fechaPublicacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.etiquetas = new ArrayList<>();
        this.existencias = existencias;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Articulo(int idArticulo, String nombre, double precio, String descripcion, int existencias, Date fechaPublicacion) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.fechaPublicacion = fechaPublicacion;
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

    public int getExistencias() {
        return existencias;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setEtiquetas(List<Etiquetas> etiquetas) {
        this.etiquetas = etiquetas;
    }
}