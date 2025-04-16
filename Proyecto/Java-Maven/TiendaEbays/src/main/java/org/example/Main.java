package org.example;

import org.example.articulos.Etiquetas;
import org.example.articulos.EtiquetasDAO;
import org.example.controladores.VistasControler;

public class Main {
    public static void main(String[] args) {

        // Actualizar la base de datos con las etiquetas
        for (Etiquetas etq: Etiquetas.values()) {
            EtiquetasDAO.comprobarInsertarEtiquetas(etq);
        }

        /*Pruebas de la base de datos
        Articulo arti1 = new Articulo("Articulo1", 10.0, "Descripcion1");
        Articulo arti2 = new Articulo( "Articulo2", 20.0, "Descripcion2");
        Articulo arti3 = new Articulo("Articulo3", 30.0, "Descripcion3");

        arti1.getEtiquetas().add(Etiquetas.ELECTRONICA);
        arti1.getEtiquetas().add(Etiquetas.JARDIN);
        arti2.getEtiquetas().add(Etiquetas.EQUIPAMIENTOINDUSTRIAL);
        arti2.getEtiquetas().add(Etiquetas.ELECTRONICA);
        arti3.getEtiquetas().add(Etiquetas.DEPORTES);

        ArticuloDAO.comprobarInsertarArticulos(arti1);

        ArticuloDAO.comprobarInsertarArticulos(arti2);

        ArticuloDAO.comprobarInsertarArticulos(arti3);
        */

        VistasControler.initVistas();



    }
}
