package org.example.users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UsuarioDAO {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void nuevoUsuario(Usuario usuario) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            //session.persist(articulo);
            session.createSQLQuery("INSERT INTO Usuarios (nombre, apellido1, apellido2, nombre_usuario, email, contrasenya) VALUES (:nombre, :apellido1, :apellido2, :nombre_usuario, :email, :contrasenya)")
                    .setParameter("nombre", usuario.getNombre())
                    .setParameter("apellido1", usuario.getApellido1())
                    .setParameter("apellido2", usuario.getApellido2())
                    .setParameter("nombre_usuario", usuario.getNombre_usuario())
                    .setParameter("email", usuario.getEmail())
                    .setParameter("contrasenya", usuario.getContrasenya())
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
    }
