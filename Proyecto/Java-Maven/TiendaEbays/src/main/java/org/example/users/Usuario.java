package org.example.users;

import org.example.articulos.Articulo;



// Solo consultas
// No puede modificar nada
public class Usuario {
    private String nombre;
    private String email;
    private String password;

    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Usuario registrar(String nombre, String email, String password) {

        return new Usuario(nombre, email, password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
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

}