package org.example.articulos;

import org.example.users.Usuario;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticuloDAO {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static final Logger log = LoggerFactory.getLogger(ArticuloDAO.class);

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
    public Articulo obtenerArticuloPorId(int id) {
        Session session = sessionFactory.openSession();
        Articulo articulo = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Object[] result = (Object[]) session.createSQLQuery(
                            "SELECT nombre, precio, descripcion, existencias FROM articulos WHERE id_articulo = :id")
                    .setParameter("id", id)
                    .uniqueResult();
            if (result != null) {
                String nombre = (String) result[0];
                double precio = ((Number) result[1]).doubleValue();
                String descripcion = (String) result[2];
                int existencias = ((Number) result[3]).intValue();
                articulo = new Articulo(nombre, precio, descripcion, existencias);
            }
            tx.commit();
        } finally {
            session.close();
        }
        return articulo;
    }
    public static List<Articulo> obtenerArticuloPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        List<Articulo> articulos = new ArrayList<>();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Object[]> results = session.createSQLQuery(
                            "SELECT precio, descripcion, existencias, nombre FROM articulos WHERE nombre LIKE :nombre")
                    .setParameter("nombre", "%" + nombre + "%")  // Concatenar los % aquí
                    .list(); // Usamos list() para obtener una lista de resultados

            for (Object[] result : results) {
                double precio = ((Number) result[0]).doubleValue();
                String descripcion = (String) result[1];
                int existencias = ((Number) result[2]).intValue();
                nombre = (String) result[3];
                articulos.add(new Articulo(nombre, precio, descripcion, existencias));
            }
            tx.commit();
        } finally {
            session.close();
        }
        return articulos; // Devolvemos la lista de artículos
    }


    public Articulo obtenerArticuloPorFecha(Date fecha) {
        Session session = sessionFactory.openSession();
        Articulo articulo = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Object[] result = (Object[]) session.createSQLQuery(
                            "SELECT nombre, precio, descripcion, existencias FROM articulos WHERE fecha_publicacion = :fecha")
                    .setParameter("fecha", fecha)
                    .uniqueResult();
            if (result != null) {
                String nombre = (String) result[0];
                double precio = ((Number) result[1]).doubleValue();
                String descripcion = (String) result[2];
                int existencias = ((Number) result[3]).intValue();
                articulo = new Articulo(nombre, precio, descripcion, existencias);
            }
            tx.commit();
        } finally {
            session.close();
        }
        return articulo;
    }

    public static List<Articulo> obtenerTodosLosArticulos() {
        List<Articulo> articulos = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                // Obtener todos los artículos
                List<Object[]> resultados = session.createSQLQuery(
                                "SELECT id_articulo, nombre, precio, descripcion, existencias, fecha_publicacion FROM articulos ORDER BY fecha_publicacion DESC")
                        .list();

                // Para cada artículo, obtener sus etiquetas
                for (Object[] row : resultados) {
                    int idArticulo = ((Number) row[0]).intValue();
                    String nombre = (String) row[1];
                    double precio = ((Number) row[2]).doubleValue();
                    String descripcion = (String) row[3];
                    int existencias = ((Number) row[4]).intValue();
                    Date fechaPublicacion = (Date) row[5];

                    Articulo articulo = new Articulo(idArticulo, nombre, precio, descripcion, existencias, fechaPublicacion);

                    // Obtener las etiquetas del artículo
                    List<Etiquetas> etiquetas = obtenerEtiquetasPorArticulo(idArticulo);
                    articulo.setEtiquetas(etiquetas);

                    articulos.add(articulo);
                }

                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
        }

        return articulos;
    }

    public static List<Etiquetas> obtenerEtiquetasPorArticulo(int idArticulo) {
        List<Etiquetas> etiquetas = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                // Obtener las etiquetas asociadas al artículo por su ID
                List<String> etiquetasResult = session.createSQLQuery(
                                "SELECT nombre_etiqueta FROM articulo_etiqueta WHERE id_articulo = :id_articulo")
                        .setParameter("id_articulo", idArticulo)
                        .list();

                // Convertir las etiquetas obtenidas en objetos de tipo Etiquetas
                for (String nombreEtiqueta : etiquetasResult) {
                    try {
                        Etiquetas etiqueta = Etiquetas.desdeNombre(nombreEtiqueta);
                        etiquetas.add(etiqueta);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Etiqueta no válida encontrada en DB: " + nombreEtiqueta);
                    }
                }

                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
        }
        return etiquetas;
    }

    public void anyadirExistencias(int idArticulo, int cantidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            int filasActualizadas = session.createSQLQuery(
                            "UPDATE articulos SET existencias = existencias + :cantidad WHERE id_articulo = :id")
                    .setParameter("cantidad", cantidad)
                    .setParameter("id", idArticulo)
                    .executeUpdate();

            if (filasActualizadas == 0) {
                System.out.println("El artículo con ID " + idArticulo + " no existe.");
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
