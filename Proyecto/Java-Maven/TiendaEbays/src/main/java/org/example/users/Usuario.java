package org.example.users;

import org.example.articulos.Articulo;

// Solo consultas
// No puede modificar nada
public class Usuario {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nombre_usuario;
    private String email;
    private String contrasenya;
    private boolean esAdmin;

    public Usuario(String nombre, String apellido1, String apellido2, String nombre_usuario, String contrasenya, String email) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre_usuario = nombre_usuario;
        this.contrasenya = contrasenya;
        this.email = email;
        this.esAdmin = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }
    public void comprar(Articulo articulo) {
        // Implementar la lógica de compra
    }

    public void vender(Articulo articulo) {
        // Implementar la lógica de venta
    }
    public void verHistorialCompras() {
        // Lógica para ver su historial de compras
    }
    public void setAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
}