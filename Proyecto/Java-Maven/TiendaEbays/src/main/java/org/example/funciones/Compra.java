package org.example.funciones;

import org.example.articulos.Articulo;
import org.example.users.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Compra {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    public static void realizarCompra(Usuario usuario, Articulo articulo, int cantidad) throws Exception {
        if (articulo.getExistencias() >= cantidad){
            try (Session session = sessionFactory.openSession()) {
                Transaction tx = session.beginTransaction();
                articulo.setExistencias(articulo.getExistencias() - cantidad);

                // Actualizar la base de datos con la nueva cantidad de existencias
                session.createSQLQuery("UPDATE articulos SET existencias = :existencias WHERE id_articulo = :id")
                        .setParameter("existencias", articulo.getExistencias())
                        .setParameter("id", articulo.getIdArticulo())
                        .executeUpdate();
                session.createSQLQuery("INSERT INTO compras (nom_user, nom_art, cantidad, fecha_compra) VALUES (:nom_usuario, :nom_articulo, :cantidad, :fecha_compra)")
                        .setParameter("nom_usuario", usuario.getNombre_usuario())
                        .setParameter("nom_articulo", articulo.getNombre())
                        .setParameter("cantidad", cantidad)
                        .setParameter("fecha_compra", new Date())
                        .executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sessionFactory.close();
            }

        } else {
           throw new Exception("No hay suficientes existencias del artículo " + articulo.getNombre());
        }
    }
}