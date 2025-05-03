package org.example.users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDAO {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void nuevoUsuario(Usuario usuario) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            //session.persist(articulo);
            session.createSQLQuery("INSERT INTO Usuarios (nombre, apellido1, apellido2, nombre_usuario, email, contrasenya, esAdmin) VALUES (:nombre, :apellido1, :apellido2, :nombre_usuario, :email, :contrasenya, :esAdmin)")
                    .setParameter("nombre", usuario.getNombre())
                    .setParameter("apellido1", usuario.getApellido1())
                    .setParameter("apellido2", usuario.getApellido2())
                    .setParameter("nombre_usuario", usuario.getNombre_usuario().toLowerCase())
                    .setParameter("email", usuario.getEmail())
                    .setParameter("contrasenya", usuario.getContrasenya())
                    .setParameter("esAdmin", usuario.isEsAdmin())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;

        } finally {
            session.close();
        }
    }

        public static boolean comprobarInsertarUsuarios(Usuario usuario) {
            Session session = sessionFactory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Integer idUsuario = (Integer) session.createSQLQuery(
                                "SELECT codigo_usuario FROM usuarios WHERE nombre = :nombre")
                        .setParameter("nombre", usuario.getNombre())
                        .uniqueResult();
                if (idUsuario == null) {
                    nuevoUsuario(usuario);
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

    public static Usuario obtenerUsuario(String nombre_usuario) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Usuario usuario = null;
        try {
            tx = session.beginTransaction();
            Object[] result = (Object[]) session.createSQLQuery(
                            "SELECT nombre, apellido1, apellido2, nombre_usuario, email, contrasenya, esAdmin " +
                                    "FROM usuarios WHERE nombre_usuario = :nombre")
                    .setParameter("nombre", nombre_usuario.toLowerCase())
                    .uniqueResult();

            if (result != null) {
                String nombre = (String) result[0];
                String apellido1 = (String) result[1];
                String apellido2 = (String) result[2];
                String nombreUsuario = (String) result[3];
                String email = (String) result[4];
                String contrasenya = (String) result[5];
                boolean esAdmin = (Boolean) result[6];

                usuario = new Usuario(nombre, apellido1, apellido2, nombreUsuario, contrasenya, email);
                usuario.setAdmin(esAdmin);
            }

            tx.commit();
            return usuario;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static boolean comprobarUsuarios(String usuario) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Integer idUsuario = (Integer) session.createSQLQuery(
                            "SELECT codigo_usuario FROM usuarios WHERE nombre_usuario = :nombre")
                    .setParameter("nombre", usuario.toLowerCase())
                    .uniqueResult();
            tx.commit();
            if (idUsuario == null) {
                return false;
            } else {

                return true;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    public static ArrayList<String[]> obtenerHistorial(Usuario usuario) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        ArrayList<String[]> historial = new ArrayList<>();
        try {
            tx = session.beginTransaction();

            List<Object[]> resultados = session.createSQLQuery(
                            "SELECT a.nombre, c.cantidad, c.fecha_compra " +
                                    "FROM compras c " +
                                    "JOIN articulos a ON c.nom_art = a.nombre " +
                                    "WHERE c.nom_user = :nom_usuario")
                    .setParameter("nom_usuario", usuario.getNombre_usuario())
                    .list();



            for (Object[] fila : resultados) {
                String nombreArticulo = (String) fila[0];
                Integer cantidad = ((Number) fila[1]).intValue();
                Date fechaCompra = (Date) fila[2];

                String[] datos = new String[] {
                        nombreArticulo,
                        String.valueOf(cantidad),
                        fechaCompra.toString().substring(0, 10)
                };
                historial.add(datos);
            }

            tx.commit();
            return historial;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void eliminarUsuario(Usuario usuario) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createSQLQuery("DELETE FROM usuarios WHERE nombre_usuario = :nombre")
                    .setParameter("nombre", usuario.getNombre_usuario())
                    .executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static ArrayList<Usuario> obtenerUsuarios() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            List<Object[]> resultados = session.createSQLQuery(
                            "SELECT nombre, apellido1, apellido2, nombre_usuario, email, contrasenya, esAdmin " +
                                    "FROM usuarios")
                    .list();

            for (Object[] fila : resultados) {
                String nombre = (String) fila[0];
                String apellido1 = (String) fila[1];
                String apellido2 = (String) fila[2];
                String nombreUsuario = (String) fila[3];
                String email = (String) fila[4];
                String contrasenya = (String) fila[5];
                boolean esAdmin = (Boolean) fila[6];

                Usuario usuario = new Usuario(nombre, apellido1, apellido2, nombreUsuario, contrasenya, email);
                usuario.setAdmin(esAdmin);
                usuarios.add(usuario);
            }

            tx.commit();
            return usuarios;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
