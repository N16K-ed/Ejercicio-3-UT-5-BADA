package org.example;

import org.example.articulos.Articulo;
import org.example.articulos.ArticuloDAO;
import org.example.articulos.Etiquetas;
import org.example.articulos.EtiquetasDAO;
import org.example.controladores.VistasControler;
import org.example.users.Usuario;
import org.example.users.UsuarioDAO;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        // Actualizar la base de datos con las etiquetas
        for (Etiquetas etq: Etiquetas.values()) {
            EtiquetasDAO.comprobarInsertarEtiquetas(etq);
        }


        Pruebas de la base de datos

        Usuario user1 = new Usuario("PEPE","1","2", "PepaPig","1234","pepa@gmail.com");
        Usuario user2 = new Usuario("MARIO","1","2", "Mario","1234","mario@gmail.com");
        Usuario user3 = new Usuario("PEPEADMIN","1","2", "PepaPigAdmin","1234","pepa@gmail.com");
        user3.setAdmin(true);

        UsuarioDAO.comprobarInsertarUsuarios(user1);
        UsuarioDAO.comprobarInsertarUsuarios(user2);
        UsuarioDAO.comprobarInsertarUsuarios(user3);

        Articulo arti1 = new Articulo("Articulo1", 10.0, "Descripcion1",1);
        Articulo arti2 = new Articulo( "Articulo2", 20.0, "Descripcion2",5);
        Articulo arti3 = new Articulo("Articulo3", 30.0, "Descripcion3",10);

        arti1.getEtiquetas().add(Etiquetas.ELECTRONICA);
        arti1.getEtiquetas().add(Etiquetas.JARDIN);
        arti2.getEtiquetas().add(Etiquetas.EQUIPAMIENTOINDUSTRIAL);
        arti2.getEtiquetas().add(Etiquetas.ELECTRONICA);
        arti3.getEtiquetas().add(Etiquetas.DEPORTES);

        user1.vender(arti1);
        user1.vender(arti2);
        user1.vender(arti3);

        user2.comprar(arti1, 2);
        user2.comprar(arti2, 3);
        List<String[]> historial = user2.verHistorialCompras();

        */

        VistasControler.initVistas();
    }
}
