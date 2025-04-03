package org.example.users;

import org.example.articulos.Articulo;

public class Administrador extends Usuario{
    private int idAdministrador;

    public Administrador(String nombre, String email, String contrasena, int idAdministrador) {
        super(nombre, email, contrasena);
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
    public void verHistorialCompras() {
        // Lógica para ver TODO el historial de compras
    }
    public void verHistorialComprasUsusario(Usuario usuario) {
        usuario.verHistorialCompras();
    }
}
