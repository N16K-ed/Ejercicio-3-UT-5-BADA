package org.example.articulos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ArticuloDAO {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private static void guardarArticulo(Articulo articulo) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            //session.persist(articulo);
            session.createSQLQuery("INSERT INTO Articulo (nombre, precio, descripcion) VALUES (:nombre, :precio, :descripcion)")
                    .setParameter("nombre", articulo.getNombre())
                    .setParameter("precio", articulo.getPrecio())
                    .setParameter("descripcion", articulo.getDescripcion())
                    .executeUpdate();
            session.getTransaction().commit();
            //session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;

        } finally {
            session.close();
        }


    }

    private static void insertEtiquetas(Articulo articulo) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Integer idArticulo = (Integer) session.createSQLQuery(
                            "SELECT id_articulo FROM articulos WHERE nombre = :nombre")
                    .setParameter("nombre", articulo.getNombre())
                    .uniqueResult();

            if (idArticulo == null) {
                throw new RuntimeException("No se encontró el artículo con nombre: " + articulo.getNombre());
            }

            for (Etiquetas etq : articulo.getEtiquetas()) {
                session.createSQLQuery("INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES (:id_articulo, :nombre_etiqueta)")
                        .setParameter("id_articulo", idArticulo)
                        .setParameter("nombre_etiqueta", etq.getNombreEtiqueta())
                        .executeUpdate();
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
