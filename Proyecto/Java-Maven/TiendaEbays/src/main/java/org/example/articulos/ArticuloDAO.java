package org.example.articulos;

import org.example.users.Usuario;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ArticuloDAO {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void guardarArticulo(Articulo articulo, Usuario usuario) {
        Integer idUsuario;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                idUsuario = (Integer) session.createSQLQuery(
                                "SELECT codigo_usuario FROM usuarios WHERE nombre = :nombre")
                        .setParameter("nombre", usuario.getNombre())
                        .uniqueResult();
                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.createSQLQuery("INSERT INTO Articulos (nombre, precio, descripcion, existencias, fecha_publicacion, codigo_usuario) VALUES (:nombre, :precio, :descripcion, :existencias, :fecha_publicacion, :codigo_usuario)")
                        .setParameter("nombre", articulo.getNombre())
                        .setParameter("precio", articulo.getPrecio())
                        .setParameter("descripcion", articulo.getDescripcion())
                        .setParameter("existencias", articulo.getExistencias())
                        .setParameter("fecha_publicacion", articulo.getFechaPublicacion())
                        .setParameter("codigo_usuario", idUsuario)
                        .executeUpdate();
                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
        }
    }

    public static void insertEtiquetas(Articulo articulo) {
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
    public static boolean comprobarInsertarArticulos(Articulo articulo, Usuario usuario) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Integer idArticulo = (Integer) session.createSQLQuery(
                            "SELECT id_articulo FROM articulos WHERE nombre = :nombre")
                    .setParameter("nombre", articulo.getNombre())
                    .uniqueResult();
            if (idArticulo == null) {
                guardarArticulo(articulo, usuario);
                insertEtiquetas(articulo);
                tx.commit();
                return true;
            } else {
                tx.commit();
                return false;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
