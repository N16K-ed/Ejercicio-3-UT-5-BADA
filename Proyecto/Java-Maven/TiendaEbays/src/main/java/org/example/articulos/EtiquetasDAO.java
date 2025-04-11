package org.example.articulos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EtiquetasDAO {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private static void insertarEtiquetasBBDD(Etiquetas etiqueta) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery("INSERT INTO etiquetas VALUES (:nombre)")
                    .setParameter("nombre", etiqueta.getNombre())
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
    public static boolean comprobarInsertarEtiquetas(Etiquetas etiqueta){
        Session session = sessionFactory.openSession();
        String nombre;
        try {
            session.beginTransaction();
            nombre = (String) session.createSQLQuery(
                            "SELECT nombre FROM etiquetas WHERE nombre = :nombre")
                    .setParameter("nombre", etiqueta.getNombre())
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;

        } finally {
            session.close();
        }

        if (nombre == null) {
            insertarEtiquetasBBDD(etiqueta);
            return true;
        }else {
            return false;
        }
    }
}