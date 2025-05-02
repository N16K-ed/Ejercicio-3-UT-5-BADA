package org.example.users;

import org.example.articulos.Articulo;

import java.util.ArrayList;


//Puede realizar las operaciones CRUD
public class Administrador extends Usuario{
    private int idAdministrador;

    public Administrador(String nombre, String apellido1, String apellido2, String nombre_usuario, String contrasenya, String email, int idAdministrador) {
        super(nombre, apellido1, apellido2, nombre_usuario, contrasenya, email);
        this.idAdministrador = idAdministrador;
    }

    public void gestionarArticulos() {
        // Lógica para gestionar artículos
    }

    public void gestionarUsuarios() {
        // Lógica para gestionar usuarios
    }

    public void gestionarCompras() {
        // Lógica para gestionar compras
    }

    public void eliminarArticulo(Articulo articulo) {
        // Lógica para eliminar un artículo
    }

    public void gestionarValoraciones() {
        // Lógica para gestionar valoraciones
    }
    @Override
    public ArrayList<String[]> verHistorialCompras() {
        // Lógica para ver TODO el historial de compras
        return null;
    }
    public void verHistorialComprasUsusario(Usuario usuario) {
        usuario.verHistorialCompras();
    }
}